public class Car{
	String make,model;
	double dir_vec[]=new double[3];   //Stores the direction of movement of the car
	int year,speed,x,y,z;
	double time_interval;		//Stores the time interval from the start of motion
	public Car(String s1,String s2,int i1,int i2,int i3,int i4,int i5,double d1,double d2,double d3){
		make=s1;
		model=s2;
		year=i1;
		speed=i2;
		x=i3;
		y=i4;
		z=i5
		dir_vec[0]=d1;
		dir_vec[1]=d2;
		dir_vec[2]=d3;
	}
	public void accelerate(int speed_increment){
		speed+=speed_increment;
	}
	public void brake(int speed_decrement){
		speed-=speed_decrement;
	}
	public void move(double t1,double t2){
		x+=(int)speed*dir_vec[0]*(t2-t1);
		y+=(int)speed*dir_vec[1]*(t2-t1);
		z+=(int)speed*dir_vec[2]*(t2-t1);
		time_interval+=t2-t1;
	}
	public boolean detect_collision(Car car2){
		double ty=(y-car2.y)/(speed*dir_vec[1]-car2.speed*car2.dir_vec[1]);
		double tx=(x-car2.x)/(speed*dir_vec[0]-car2.speed*car2.dir_vec[0]);
		double tz=(z-car2.z)/(speed*dir_vec[2]-car2.speed*car2.dir_vec[2]);
		if(ty==tx && tz==tx){
			return true;
		}
		return false;
	}
	public double time_to_collision(Car car2){
		if(detect_collision(car2)){
			return (y-car2.y)/(speed*dir_vec[1]-car2.speed*car2.dir_vec[1]);
		}
	}
	public static void main(String[]args){
		Car c1=new Car("Maruti","Alto",2016,5,0,0,0.8,0.6,0.0);
		Car c2=new Car("Maruti","Alto",2016,5,0,3,1.0,0.0,0.0);
		System.out.print(c1.detect_collision(c2));
	}
}