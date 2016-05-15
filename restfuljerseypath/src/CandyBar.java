
public class CandyBar {

	public static void main(String[] args) {
		System.out.println(distributeCadbury(5, 6, 3, 4));
	}
	 public static int distributeCadbury(int input1,int input2,int input3,int input4)
	    {	int childCounter = 0;	 
		 if(input2>=input1 && input4>=input3&&input1>0&&input2>0&&input3>0&&input4>0 ){
      
     for(int i = input1;i<=input2;i++) {
    	 
    	 for(int j = input3;j<=input4;j++){
    		 //System.out.println(i+"X"+j);
    		 int remainingRow = i;int remainingColumn = j;
      while(true){
    	  if(remainingRow>remainingColumn){
    		  remainingRow = remainingRow-remainingColumn;
    	  childCounter++;
    	  }
    	  else if(remainingColumn>remainingRow){
    		  remainingColumn = remainingColumn-remainingRow;
    		  childCounter++;
    	  }
    	  else {
    		  remainingColumn=0;
    		  remainingColumn=0;
    		  childCounter++;
    		  break;
    	  }
    	  
    	  
      }
      
      
     }
      }
		 }
    return childCounter;
    }
}
