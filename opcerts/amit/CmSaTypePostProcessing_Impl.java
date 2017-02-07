package com.splwg.cm.domain.SQL;

import java.math.BigInteger;

import com.splwg.base.api.datatypes.Bool;
import com.splwg.base.api.datatypes.Date;
import com.splwg.ccb.api.lookup.BillSegmentStatusLookup;
import com.splwg.ccb.domain.admin.serviceAgreementType.SaTypePostProcessingAlgorithmSpot;
import com.splwg.ccb.domain.billing.bill.Bill;
import com.splwg.ccb.domain.billing.bill.BillGenerationData;
import com.splwg.ccb.domain.billing.bill.Bill_Id;
import com.splwg.ccb.domain.billing.billSegment.BillSegment;
import com.splwg.ccb.domain.billing.billSegment.BillSegmentData;
import com.splwg.ccb.domain.billing.billSegment.BillSegment_DTO;
import com.splwg.ccb.domain.customerinfo.serviceAgreement.ServiceAgreement_Id;
import com.splwg.shared.logging.LoggerFactory;

/**
 * @author adhomane
 *
@AlgorithmComponent ()
 */
public class CmSaTypePostProcessing_Impl extends CmSaTypePostProcessing_Gen
		implements SaTypePostProcessingAlgorithmSpot {
	com.splwg.shared.logging.Logger lg=LoggerFactory.getLogger(CmSaTypePostProcessing.class);
String saID,billId;
	@Override
	public void invoke() {
		// TODO Auto-generated method stub
		lg.error("inside invoke   +");	;
		lg.error("bill id is"+billId);
		 Bill_Id billid=new Bill_Id(billId);
		Bill bill =billid.getEntity();

		 BillSegment bdBillSegment;
		 
		 BillSegmentData  bdBillSegmentData=BillSegmentData.Factory.newInstance();
		 
		 BillSegment_DTO paramBillSegment_DTO=new BillSegment_DTO();
		 
		 paramBillSegment_DTO.setBillId(billid);
		 paramBillSegment_DTO.setCreationDateTime(getSystemDateTime());
		 paramBillSegment_DTO.setServiceAgreementId(new ServiceAgreement_Id(saID));
		 paramBillSegment_DTO.setStartDate(getSystemDateTime().getDate());
		  
		bdBillSegment=paramBillSegment_DTO.newEntity();
		  
		bdBillSegment.getServiceQuantities();
		
		
		 bdBillSegmentData.setBillSegmentDto(paramBillSegment_DTO); 
	}

	@Override
	public String getAccountId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getAccountingDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bool getAllowEstSw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bool getAsgnSeqNbrSw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bool getBillCompleteSw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillCycCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getBillDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillId() {
		// TODO Auto-generated method stub
		return billId;
	}

	@Override
	public Bool getBillOptSw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBsbsxAccountId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBsbsxBillCycCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBsbsxBillId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getBsbsxEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBsbsxSaId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getBsbsxStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCisDivision() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCutOffDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getEstDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bool getFreezeCmpSw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bool getMidTrxCommitSw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSaId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSaTypeCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bool getSkipSw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateSw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAccountId(String paramString) {
		// TODO Auto-generated method stub
		lg.error("inside setAccountId  =paramString+"+paramString);	;
	}

	@Override
	public void setAccountingDate(Date paramDate) {
		// TODO Auto-generated method stub
		lg.error("inside setAccountingDate  =paramString+"+paramDate);	;
	}

	@Override
	public void setAllowEstSw(Bool paramBool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsgnSeqNbrSw(Bool paramBool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBillCompleteSw(Bool paramBool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBillCycCode(String paramString) {
		// TODO Auto-generated method stub
		lg.error("inside setBillCycCode  =paramString+"+paramString);	;
	}

	@Override
	public void setBillDate(Date paramDate) {
		// TODO Auto-generated method stub
		lg.error("inside setBillDate  =paramString+"+paramDate);	;
	}

	@Override
	public void setBillId(String billId) {
		// TODO Auto-generated method stub
		this.billId=billId;
		

 
	}

	@Override
	public void setBillOptSw(Bool paramBool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBsbsxAccountId(String paramString) {
		// TODO Auto-generated method stub
		lg.error("inside setBsbsxAccountId  =paramString+"+paramString);	;
	}

	@Override
	public void setBsbsxBillCycCode(String paramString) {
		// TODO Auto-generated method stub
		lg.error("inside setBsbsxAccountId  =paramString+"+paramString);	;
	}

	@Override
	public void setBsbsxBillId(String paramString) {
		// TODO Auto-generated method stub
		 
		lg.error("inside setBsbsxBillId saID=paramString+"+paramString);	;
	}

	@Override
	public void setBsbsxEndDate(Date paramDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBsbsxSaId(String paramString) {
		// TODO Auto-generated method stub
		saID=paramString;
		lg.error("inside setBsbsxSaId saID=paramString+"+paramString);	;
	}

	@Override
	public void setBsbsxStartDate(Date paramDate) {
		// TODO Auto-generated method stub
		lg.error("inside setBsbsxStartDate saID=paramString+"+paramDate);	;
	}

	@Override
	public void setCisDivision(String paramString) {
		// TODO Auto-generated method stub
		lg.error("inside setCisDivision saID=paramString+"+paramString);	;
	}

	@Override
	public void setCutOffDate(Date paramDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEndDate(Date paramDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEstDate(Date paramDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFreezeCmpSw(Bool paramBool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMidTrxCommitSw(Bool paramBool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSaId(String paramString) {
		// TODO Auto-generated method stub
		saID=paramString;
	lg.error("inside setSaId saID=paramString+"+paramString);	;
	}

	@Override
	public void setSaTypeCode(String paramString) {
		// TODO Auto-generated method stub
		lg.error("inside setSaTypeCode saID=paramString+"+paramString);	;
	}

	@Override
	public void setSkipSw(Bool paramBool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStartDate(Date paramDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateSw(String paramString) {
		// TODO Auto-generated method stub

	}

	@Override
	public BigInteger getBatchRunNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBillGenType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrialBillId() {
		// TODO Auto-generated method stub
		return null;
	}

}
