import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
public class CandidateCode 
{ 
	public static void main(String[] args){
		String ip4 = "((2,1),(6,6),(4,2),(2,5),(2,6),(2,7),(3,4),(6,1),(6,2),(2,3),(6,3),(6,4),(6,5),(6,7))";
		int ip1 = 6;
		int ip2 = 7;
		int ip3 = 14;
		int t = maxTreeDestroyed(ip1, ip2,ip3, ip4);
		System.out.println(t);
	}

    public static int maxTreeDestroyed(int input1,int input2,int input3,String input4)
    {	String temp = input4.replaceAll("\\(\\(", "");
    List firstList = new LinkedList();
   Map counter = new HashMap();
    {	 temp = temp.replaceAll("\\)\\)", "");
        String[] finale = temp.split("\\),\\(");
        List<String> justList = Arrays.asList(finale);
        int ct = 0;
       int[][] matrix  = new int[input1+1][input2+1];
       String tempa = "";
       	for(int i = 1;i<=input1;i++){
       		for(int j = 1;j<=input2;j++){
       		//System.out.println(i+","+j);
       			tempa = String.valueOf(i)+","+String.valueOf(j);
       			if(justList.contains(tempa)){
       				matrix[i][j] = 1;
       				ct++;
       			}
       		}
       	}
       	int previ = 0;int prevj = 0;
    	for(int i = 1;i<=input1;i++){
       		for(int j = 1;j<=input2;j++){
       		
       			if(matrix[i][j]!=0){
       				if(i==0&&j==0){
       				previ = i;prevj = j;
       				}
       				if(){
       					
       				}
       			}
       			System.out.print(matrix[i][j] + " ");
       		}
       		System.out.println("");
       	
    	}
        System.out.println(ct+"  Count");
        return matrix.length;
    }
}}