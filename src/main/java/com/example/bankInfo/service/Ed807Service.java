package com.example.bankInfo.service;

import com.example.bankInfo.converter.DateConverter;
import com.example.bankInfo.converter.Ed807Converter;
import com.example.bankInfo.entity.*;
import com.example.bankInfo.mapper.*;
import com.example.bankInfo.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.cbr.ed.v2.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.bankInfo.converter.DateConverter.toXMLGregorianCalendar;

@Service
@RequiredArgsConstructor
public class Ed807Service {

    private final BicDirectoryEntryTypeRepository bicDirectoryEntryTypeRepository;
    private final Ed807Repository ed807Repository;
    private final SwBicsRepository swBicsRepository;
    private final AccountsTypeRepository accountsTypeRepository;
    private final ParticipantInfoTypeRepository participantInfoTypeRepository;
    private final RstrListTypeRepository rstrListTypeRepository;
    private final AccRstrListRepository accRstrListRepository;
    private final BicDirectoryEntryTypeMapper bicDirectoryEntryTypeMapper;
    private final ParticipantInfoTypeMapper participantInfoTypeMapper;
    private final RstrListTypeMapper rstrListTypeMapper;
    private final SwBicMapper swBicMapper;
    private final AccountsTypeMapper accountsTypeMapper;
    private final AccRstrListMapper accRstrListMapper;
    private final Ed807Mapper ed807Mapper;
    private final Ed807Converter ed807Converter;


    /**
     * Метод для разбора входного {@link ED807} в набор сущностей для последующего сохранения в БД.
     * @param ed807RequestDto входное DTO.
     * @return DTO ответа {@link ED807}.
     */
    public ED807 createEd807(ED807 ed807RequestDto) {
        Ed807Entity ed807Entity = ed807Converter.ed807DtoToEntity(ed807RequestDto);
        ed807Entity.setEdAuthor(ed807RequestDto.getEDAuthor());
        ed807Entity.setEdDate(ed807RequestDto.getEDDate());
        ed807Entity.setEdNo(ed807RequestDto.getEDNo());
        Ed807Entity ed807saved = ed807Repository.save(ed807Entity);

        List<BICDirectoryEntryType> bicDirectoryEntryTypeList = ed807RequestDto.getBICDirectoryEntry();
        List<BICDirectoryEntryTypeEntity> bicDirectoryEntryTypeEntityList = new ArrayList<>();


        for (BICDirectoryEntryType bicDirectoryEntryType : bicDirectoryEntryTypeList) {
            BICDirectoryEntryTypeEntity bicDirectoryEntryTypeEntity = bicDirectoryEntryTypeMapper
                    .bicDirectoryEntryTypeToEntity(bicDirectoryEntryType);
            bicDirectoryEntryTypeEntity.setEd807EntityId(ed807saved);
            bicDirectoryEntryTypeEntityList.add(bicDirectoryEntryTypeEntity);


            bicDirectoryEntryTypeEntity.setParticipantInfo(participantInfoTypeMapper
                    .participantInfoTypeToEntity(bicDirectoryEntryType.getParticipantInfo()));

            BICDirectoryEntryTypeEntity bicDirectoryEntryTypeEntitySaved = bicDirectoryEntryTypeRepository.save(bicDirectoryEntryTypeEntity);

            List<SWBICList> swbicListListDto = bicDirectoryEntryType.getSWBICS();
            List<SwBicsEntity> swBicsEntityList = new ArrayList<>();

            for (SWBICList swbicList : swbicListListDto) {
                SwBicsEntity swBicsEntity = swBicMapper.swBicToEntity(swbicList);
                swBicsEntity.setBicDirectoryEntryTypeEntity(bicDirectoryEntryTypeEntitySaved);
                swBicsEntityList.add(swBicsEntity);
                swBicsRepository.save(swBicsEntity);
            }


            List<AccountsType> accountsInfoTypeList = bicDirectoryEntryType.getAccounts();
            List<AccountsTypeEntity> accountsTypeEntityList = new ArrayList<>();

            for (AccountsType accountsType : accountsInfoTypeList) {
                AccountsTypeEntity accountsTypeEntity = accountsTypeMapper.accountsTypeToEntity(accountsType);
                accountsTypeEntity.setBicDirectoryEntryTypeEntity(bicDirectoryEntryTypeEntitySaved);
                accountsTypeEntityList.add(accountsTypeEntity);
                AccountsTypeEntity accountsTypeEntitySaved = accountsTypeRepository.save(accountsTypeEntity);
                List<AccRstrListType> accRstrListTypeList = accountsType.getAccRstrList();
                for (AccRstrListType accRstrListType : accRstrListTypeList) {
                    AccRstrListEntity accRstrListEntity = accRstrListMapper.AccRstrListToEntity(accRstrListType);
                    accRstrListEntity.setAccountsType(accountsTypeEntitySaved);
                    accRstrListRepository.save(accRstrListEntity);
                }

            }
            ParticipantInfoTypeEntity participantInfoTypeEntity = bicDirectoryEntryTypeEntitySaved.getParticipantInfo();
            ParticipantInfoType participantInfoType = bicDirectoryEntryType.getParticipantInfo();

            List<RstrListType> rstrListTypeList = participantInfoType.getRstrList();
            List<RstrListTypeEntity> rstrListTypeEntityList = new ArrayList<>();

            for (RstrListType rstrListType : rstrListTypeList) {
                RstrListTypeEntity rstrListTypeEntity = rstrListTypeMapper.rstrListTypeToEntity(rstrListType);
                rstrListTypeEntity.setParticipantInfoTypeEntity(participantInfoTypeEntity);
                rstrListTypeEntityList.add(rstrListTypeEntity);
                rstrListTypeRepository.save(rstrListTypeEntity);
            }


        }
        ed807saved.setBicDirectoryEntry(bicDirectoryEntryTypeEntityList);


        ED807 ed807 = new ED807();
        BeanUtils.copyProperties(ed807saved, ed807);
        return ed807;
    }

//    public ED807 updateED807(Long id, ED807 ed807RequestDto){
//        Ed807Entity ed807Entity =ed807Repository.findById(id).orElseThrow(() ->
//                new EntityNotFoundException("Ed807 not found"));
//        ed807Entity = ed807Converter.ed807DtoToEntity(ed807RequestDto);
//        ed807Entity.setEdAuthor(ed807RequestDto.getEDAuthor());
//        ed807Entity.setEdDate(ed807RequestDto.getEDDate());
//        ed807Entity.setEdNo(ed807RequestDto.getEDNo());
//        Ed807Entity ed807EntityResult =ed807Repository.save(ed807Entity);
//        ED807 ed807ResponseDto  = ed807Mapper.ed807EntityToED807(ed807EntityResult);
//        ed807ResponseDto.setEDAuthor(ed807EntityResult.getEdAuthor());
//        ed807ResponseDto.setEDDate(toXMLGregorianCalendar( ed807EntityResult.getEdDate()));
//        ed807ResponseDto.setEDNo(ed807EntityResult.getEdNo());
//        return ed807ResponseDto;
//
//    }




}
















