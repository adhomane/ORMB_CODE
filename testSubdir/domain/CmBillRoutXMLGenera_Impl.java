package com.splwg.cm.domain.SQL;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.splwg.base.api.datatypes.Bool;
import com.splwg.base.api.sql.SQLResultRow;
import com.splwg.base.domain.batch.batchControl.BatchControl;
import com.splwg.base.domain.common.algorithm.Algorithm;
import com.splwg.base.domain.report.reportDefinition.ReportDefinition;
import com.splwg.ccb.domain.admin.billRouteType.BillRouteTypeBillExtractAlgorithmSpot;
import com.splwg.ccb.domain.billing.bill.Bill;
import com.splwg.ccb.domain.billing.trialBilling.TrialBill;
import com.splwg.ccb.domain.common.fileHelper.FileHelper;

/**
 * @author adhomane
 *
@AlgorithmComponent ()
 */
public class CmBillRoutXMLGenera_Impl extends CmBillRoutXMLGenera_Gen implements
		BillRouteTypeBillExtractAlgorithmSpot {

	Bill bill;
	String fileName;
	@Override
	public Bool getIsBillSkipped() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportDefinition getReportDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger getReturnCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBatchControl(BatchControl arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBatchNumber(BigInteger arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBill(Bill bill) {
		// TODO Auto-generated method stub
		this.bill=bill;
	}

	@Override
	public void setExtractAlgorithm(Algorithm arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setExtractFileName(String fileName) {
		// TODO Auto-generated method stub
this.fileName=fileName;
	}

	@Override
	public void setFileHelper(FileHelper arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIsTrialBill(Bool arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNumberOfCopies(BigInteger arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSequenceNumber(BigInteger arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToBill(Bill bill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setToTrialBill(TrialBill arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTrialBill(TrialBill arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void invoke() {
		// TODO Auto-generated method stub
		billDetails(  bill);
		
		
	}
public void billDetails(Bill bill)
{

String sql="SELECT ACCTNBR.ACCT_NBR, " +
"  PER_NAME.ENTITY_NAME_UPR, " +
"  bsegEXRT.PRICEITEM_CD, " +
"  PRICEITEM_L.DESCR, " +
"  bsegEXRT.USAGE_ACCT_ID, " +
"  bsegcalln.BILL_SQ AS QUANTITY, " +
"  (SELECT c1.ADHOC_CHAR_VAL " +
"  FROM CI_BSEG_CL_CHAR c1 " +
"  WHERE C1.BSEG_ID    =bsegcalln.BSEG_ID " +
"  AND C1.SEQNO        =bsegcalln.SEQNO " +
"  AND C1.HEADER_SEQ   =bsegcalln.HEADER_SEQ " +
"  AND C1.CHAR_TYPE_CD = 'RVALUECH' " +
"  AND ROWNUM         <= 1 " +
"  ) AS RATE, " +
"  bsegcalln.CALC_AMT, " +
"  bsegcalln.BSEG_ID, " +
"  bsegCal.HEADER_SEQ, " +
"  bsegcalln.SEQNO " +
"FROM ci_bseg Bseg , " +
"  CI_BSEG_CALC bsegCal, " +
"  CI_BSEG_CALC_LN bsegcalln, " +
"  CI_BSEG_EXT bsegEXRT , " +
"  CI_PRICEITEM_L PRICEITEM_L , " +
"  CI_ACCT_NBR ACCTNBR , " +
"  CI_PER_NAME PER_NAME, " +
"  CI_ACCT_PER ACCT_ID " +
"WHERE Bseg.BSEG_ID          =bsegCal.BSEG_ID " +
"AND bsegCal.BSEG_ID         =bsegcalln.BSEG_ID " +
"AND bsegEXRT.BSEG_ID        =bsegcalln.BSEG_ID " +
"AND ACCTNBR.ACCT_ID         =bsegEXRT.USAGE_ACCT_ID " +
"AND ACCT_ID.ACCT_ID         =ACCTNBR.ACCT_ID " +
"AND PER_NAME.PER_ID         =ACCT_ID.PER_ID " +
"AND PRICEITEM_L.PRICEITEM_CD=bsegEXRT.PRICEITEM_CD " +
"AND EXISTS " +
"  (SELECT * " +
"  FROM ci_ft FT " +
"  WHERE FT.PARENT_ID  =FT.bill_id " +
"  AND FT.SIBLING_ID   =Bseg.BSEG_ID " +
"  AND FT.FREEZE_SW    ='Y' " +
"  AND FT.FT_TYPE_FLG IN ('BS','BX') " +
"  AND FT.BILL_ID      =:billID " +
"  )";

com.splwg.base.api.sql.PreparedStatement pstmt    =createPreparedStatement(sql, "execute");
pstmt.bindEntity("billID", bill);
pstmt.execute();

List<SQLResultRow> listpt=pstmt.list();
Document docment=DocumentHelper.createDocument();
Element rootElement=docment.addElement("billInformation");
Element rootElement1 = null;
com.ibm.icu.math.BigDecimal totalAmount=new com.ibm.icu.math.BigDecimal(BigInteger.ZERO);
			for(SQLResultRow ptst  :listpt)
			{	
				 
				
				
				  rootElement1=	rootElement.addElement("repeatListElement");
				
				rootElement1.addElement("acctNumber").setText(ptst.getString("ACCT_NBR"));
				rootElement1.addElement("entityName").setText(ptst.getString("ENTITY_NAME_UPR"));
				rootElement1.addElement("productDesc").setText(ptst.getString("DESCR"));
				rootElement1.addElement("quantity").setText(ptst.getBigDecimal("QUANTITY").setScale(2).toString());
				rootElement1.addElement("rateApplied").setText(new BigDecimal(ptst.getString("RATE")).setScale(2).toString());
				rootElement1.addElement("calcuAmount").setText(ptst.getBigDecimal("CALC_AMT").setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				totalAmount=totalAmount.add(ptst.getBigDecimal("CALC_AMT").setScale(2));
				
			 
				
			//ptst.getBigDecimal("RATE").toString()	
			}
			Element elem=	rootElement.addElement("totAmountCalcGroup");
			
			elem.addElement("totAmountCalc").setText(totalAmount.toString());
			
			FileWriter FW;
			try {
				FW = new FileWriter(fileName);
				FW.write(docment.asXML());
				FW.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
}
	
	
	
}
