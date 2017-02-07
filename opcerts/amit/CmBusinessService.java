package com.splwg.cm.domain.SQL;

import java.util.List;

import com.splwg.base.api.Query;
import com.splwg.base.api.service.DataElement;
import com.splwg.base.api.service.ItemList;
import com.splwg.base.api.service.PageBody;
import com.splwg.base.api.service.PageHeader;
import com.splwg.ccb.domain.customerinfo.account.Account;
import com.splwg.ccb.domain.customerinfo.person.Person;
import com.splwg.ccb.domain.customerinfo.person.Person_Id;
import com.splwg.shared.common.ApplicationError;

/**
 * @author adhomane
 *
@PageMaintenance (program = CMBSSER, service = CMBSSER,
 *      body = @DataElement (contents = { @ListField (name = cmList)
 *                  , @FieldGroup (name = inputGroup,
 *                        contents = { @DataField (name = ACCOUNT_ID)
 *                              , @DataField (name = PER_ID)})}),
 *      actions = { "change"
 *            , "delete"
 *            , "read"
 *            , "add"},
 *      header = { @DataField (name = PER_ID)},
 *      headerFields = { @DataField (name = PER_ID)},
 *      lists = { @List (name = cmList, size = 50,
 *                  body = @DataElement (contents = { @ListDataField (name = ACCT_ID)
 *                              , @ListDataField (name = PER_ID)}))},
 *      modules = { "demo"})
 */
public class CmBusinessService extends CmBusinessService_Gen {

	@Override
	protected DataElement read(PageHeader header) throws ApplicationError {
		// TODO Auto-generated method stub
		
		String personID=	header.get(CmBusinessService_Gen.STRUCTURE.HEADER.PER_ID);
		
		Query<Account> queryObj=createQuery("from AccountPerson acctPer where acctPer.id.person=:personid ");
		queryObj.addResult("accountId", "acctPer.id.account");
		queryObj.bindEntity("personid", new Person_Id(personID).getEntity());
		  List<Account>	accountIdList=queryObj.list();
		
		 
		  DataElement  dtBodyElem = null;
		  
		 // dt.put(CmBusinessService_Gen.STRUCTURE.ACCOUNT_ID, accountIdList.getId().getIdValue());
		  ItemList  itemLi=new ItemList (CmBusinessService_Gen.STRUCTURE.list_cmList.name);
		  for( Account acct : accountIdList)
		  {System.out.println("inside");
			     dtBodyElem=	  itemLi.newDataElement();
			  dtBodyElem.put(CmBusinessService_Gen.STRUCTURE.list_cmList.ACCT_ID, acct.getId().getIdValue());
			  dtBodyElem.put(CmBusinessService_Gen.STRUCTURE.list_cmList.PER_ID, acct.getId().getIdValue()); 
			  
		  }
		  dtBodyElem.addList(itemLi)  ;
		  
		  
		  return dtBodyElem;
		  
		
		
		
	}

	@Override
	protected PageHeader add(DataElement item) throws ApplicationError {
		// TODO Auto-generated method stub
		return super.add(item);
	}

	@Override
	protected void change(DataElement item) throws ApplicationError {
		// TODO Auto-generated method stub
		super.change(item);
	}

	@Override
	protected void delete(DataElement item) throws ApplicationError {
		// TODO Auto-generated method stub
		super.delete(item);
	}

	
	
	
	
}
