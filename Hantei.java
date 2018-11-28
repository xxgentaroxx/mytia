public class Hantei{
    int y_location;
    final int EXCELLENT=2;
    final int GREAT=10;
    final int NICE=20;
    final int EXPOINT=50;
    final int GRPOINT=30;
    final int NIPOINT=10;
    final int MISSPOINT=0;
    final int MISSPENALTY=10;
    Hantei(int default_y){
    	this.y_location=default_y;
    }
    //define center of judge

    public int JudgeScore(int moji, int input, int moji_y){
    	int distance=Math.abs(moji_y-this.y_location);
    	System.out.println("distance="+distance);
    	System.out.println("moji_y="+moji_y);
    	System.out.println("y_location="+y_location);
    	int penalty=0;
    	if(moji!=input){
    		penalty=MISSPENALTY;
    	}
		if(distance<=EXCELLENT){
		    return EXPOINT-penalty;
		}else if(distance<=GREAT){
		    return GRPOINT-penalty;
		}else if(distance<=NICE){
		    return NIPOINT-penalty;
		} else {
			return MISSPOINT-penalty;
		}
	}

    public String Judge(int moji,int input,int moji_y){
		int distance=Math.abs(moji_y-this.y_location);
		if(moji!=input){
		    return "WRONG LETTER";
		}else if(distance<=EXCELLENT){
		    return "EXCELLENT";
		}else if(distance<=GREAT){
		    return "GREAT";
		}else if(distance<=NICE){
		    return "NICE";
		} else {
			return "MISS";
		}
    }
}