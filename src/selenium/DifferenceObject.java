package selenium;

import java.util.*;

public class DifferenceObject {
	
	
	HashMap<String, String> baseItems = new HashMap<String, String>();
	HashMap<String, String> cycleItems = new HashMap();
	
	ArrayList baseList = new ArrayList();
	ArrayList cycleList = new ArrayList();

	public DifferenceObject(){
		
	}
	
	public HashMap<String,String> getBaseHashItem(int i){
		HashMap<String, String> localMap = (HashMap<String, String>) this.baseList.get(i);
		return localMap;
	}
	
	public void putBaseHashItem(HashMap<String, String> hash){
		this.baseList.add(hash);
	}
	
	public HashMap<String,String> getCycleHashItem(int i){
		HashMap<String, String> localMap = (HashMap<String, String>) this.cycleList.get(i);
		return localMap;
	}
	
	public void putCycleHashItem(HashMap<String, String> hash){
		this.cycleList.add(hash);
	}
}
