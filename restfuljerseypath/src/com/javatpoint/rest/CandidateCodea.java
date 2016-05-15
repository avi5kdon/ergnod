package com.javatpoint.rest;
//package com.javatpoint.rest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class CandidateCodea 
{ 
	

    public static int[] getJoinedPipes(int[] input1,int input2)
    {
    	
    	if(input2 == 1){
    		int[] rew  = new int[1];
    		rew[0] = 0;
    		return rew;
    	}
    	List<Integer> initList = new ArrayList<Integer>();
    	for(Integer i : input1){
    		initList.add(i);
    	}
    	List<Integer[]> initLista = new ArrayList<Integer[]>();
    	List<Integer[]> arrList = new ArrayList<Integer[]>();

    initLista = permute(initList, 0,arrList);
    StringBuilder sumString = new StringBuilder();
    ArrayList<ArrayList> outputArray = new ArrayList<ArrayList>();
   for(Integer[] ar : initLista){
    	for(int i= 0;i< input2;i++){
    		ArrayList<Integer> sumList = new ArrayList<Integer>();
    		int tempSum = ar[i];
    		
    		for(int j = 0;j<input2;j++){
    			if(i==j){
    				continue;
    			}
    			tempSum = tempSum+ar[j];
    			sumString.append(String.valueOf(tempSum));
    			sumList.add(tempSum);
    			if(i == input2-1 && j==i-1){
    				continue;
    			}
    			if(j<input2-1){
    				sumString.append(",");
    			}
    		}
    		sumString.append("#");
    		outputArray.add(sumList);
    	}
    	
   }
  
   Map<List<Integer>,Integer> massMap = new HashMap();
   for(ArrayList al : outputArray){
	   int sum = 0;
	   for(int i = 0;i< al.size();i++){
		   sum = sum+(int)al.get(i);
		   
	   }
	   
	   massMap.put(al, sum);
   }
   
 
   
   
   
   
   
   
   
   

   Set<List<Integer>> mapKeys = massMap.keySet();
   List<Integer> mapValues = new ArrayList<>(massMap.values());
   Collections.sort(mapValues);
  

   LinkedHashMap<List<Integer>, Integer> sortedMap =
       new LinkedHashMap<>();

   Iterator<Integer> valueIt = mapValues.iterator();
   while (valueIt.hasNext()) {
       Integer val = valueIt.next();
       Iterator<List<Integer>> keyIt = mapKeys.iterator();

       while (keyIt.hasNext()) {
           List<Integer> key = keyIt.next();
           Integer comp1 = massMap.get(key);
           Integer comp2 = val;

           if (comp1.equals(comp2)) {
               keyIt.remove();
               sortedMap.put(key, val);
               break;
           }
       }
   }
  
   
   int[] returner = new int[input2-1];
  Set<List<Integer>> retSet = sortedMap.keySet();
   Iterator it = retSet.iterator();
 ArrayList<Integer> retList =   (ArrayList<Integer>) it.next();
   Integer[] ret =  retList.toArray(new Integer[0]);
        for(int i = 0;i<ret.length;i++){
        	returner[i] = ret[i];
        	
        }
   
    return returner;
    }
    
    
    static List<Integer[]> permute(java.util.List<Integer> arr, int k,List<Integer[]> arrList){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1,arrList);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
        	
        	arrList.add(arr.toArray(new Integer[0]));
        	//arrList.add(arr.toArray());
          // System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
		return arrList;
    }
}