package practice;

public class practice2 {
	private int speed = 0;
	private int maxSpeed = 100;
	public static void main(String[] args) {
		
	}

	public int getSpeed()
	{
	    return speed;
	}

    public int getMaxSpeed()
	{
	    return maxSpeed;
    }

	public void speedUp(int increment)
	{
	    if(speed + increment > maxSpeed){
	        throw new IllegalArgumentException("Final speed can not be greater than 100");
	    }else{
	        speed += increment;
	    }
 }
    public void speedDown(int decrement)
	{
	    if(speed - decrement < 0){
	        throw new IllegalArgumentException("Final speed can not be less than zero");
	    }else{
	        speed -= decrement;
	    }
	}
}


