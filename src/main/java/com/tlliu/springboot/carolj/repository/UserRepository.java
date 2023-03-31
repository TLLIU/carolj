package com.tlliu.springboot.carolj.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tlliu.springboot.carolj.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, BigDecimal>, JpaSpecificationExecutor<User>{
    @Query("select u from com.tlliu.springboot.carolj.model.User u where u.mailAddress = :mailAddress")
    User getUserByMailAddress(@Param("mailAddress") String mailAddress);

    @Modifying
    @Transactional
    @Query("update com.tlliu.springboot.carolj.model.User u set u.phoneNumber = :phoneNumber where u.mailAddress in (:mailAddresses)")
    int setPhoneNumberByMailAddress(@Param("phoneNumber") String number, @Param("mailAddresses") List<String> mailAddresses);


    // @Query("select new com.citi.kyc.core.services.brms.domain.PeriodicAttestDTO(tg.localTaskID, "
    //         + "tg.WorkItemType, tg.taskRole, (select usr.firstName || ' ' ||usr.lastName from com.citi.kyc.core.userprofile.domain.UserProfile usr where usr.id = tg.workItemAssignedTo) as workItemAssignedTo, "
    //         +"(select grp.groupDescriptor from com.citi.kyc.core.permissions.domain.Group frp where grp.groupCode = tg.groupCode) as groupCode, tg.workItemStatus)"
    //         + " from com.citi.kyc.core.services.brms.domain.TaskGlobal tg, ProcessInstanceXref xref"
    //         + " where xref.parentProcessInstanceXrefId = "
    //         + "(select globalProcessInstanceId.uuid from com.citi.kyc.core.services.brms.domain.TaskGlobal where id.uuid= :globalWorkItemId) and tg.globalProcessInstanceId.uuid = xref.id.uuid order by tg.localTaskID")
    // List<PeriodicAttestDTO> getAttestationSummaryById(@Param("globalWorkItemId") String globalWorkItemId);
    
    List<User> findByCountry(Integer country, Pageable pageable);

    List<User> findByNameIn(List<String> names, Pageable pageable);


}
