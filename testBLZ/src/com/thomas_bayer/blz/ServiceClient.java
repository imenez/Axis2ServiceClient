package com.thomas_bayer.blz;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.thomas_bayer.blz.BLZServiceStub.GetBank;
import com.thomas_bayer.blz.BLZServiceStub.GetBankResponse;
import com.thomas_bayer.blz.BLZServiceStub.GetBankType;
import java.util.Scanner;

public class ServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String blzCode;
		
		try {
			BLZServiceStub stub = new BLZServiceStub();
			GetBank request = new GetBank();
			GetBankType getBankType = new GetBankType();
			
			Scanner scanner = new Scanner(System.in);
			blzCode = scanner.next(); 
			
			//getBankType.setBlz("38070059");//example blz code or "10000000"
			getBankType.setBlz(blzCode);
			request.setGetBank(getBankType);
			
			GetBankResponse response = stub.getBank(request);
			
			System.out.println("Response \nbezeichnung: " + response.getGetBankResponse().getDetails().getBezeichnung());
			System.out.println("bic: " + response.getGetBankResponse().getDetails().getBic());
			System.out.println("ort: " + response.getGetBankResponse().getDetails().getOrt());
			System.out.println("plz: " + response.getGetBankResponse().getDetails().getPlz());
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
