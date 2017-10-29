package pokemon_2;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	
	private String name;
	private Type type;
	private Trainer trainer;
	private int number;
	private static int nextnumber;
	private boolean hastrainer;
	private boolean swapAllow;
	private List<Swap> swaps = new ArrayList<Swap>();
	
	
	public Pokemon(String name, Type type){
		this.name = name;
		this.type = type;
		this.number = nextnumber;
		nextnumber++;	
		this.swapAllow = true;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public int getNextnumber(){
		return this.number +1;
	}
	
	public void setHasTrainer(boolean status){
		this.hastrainer = status;
	}
	
	public void setTrainer(Trainer newTrainer){
		if(this.hastrainer == false){
		this.trainer = newTrainer;
		this.setHasTrainer(true);
		}
		else{
			System.err.println("This pokemon alread has a trainer!");
		}
	}
	
	public void removeTrainer(){
		this.trainer = null;
		this.setHasTrainer(false);
	}
	
	public Trainer getTrainer(){
		return this.trainer;
	}
	
	public boolean getHasTrainer(){
		return hastrainer;
	}
	
	public void setSwapStatus(boolean status){
		this.swapAllow = status;
	}
	
	public boolean getSwapStatus(){
		return this.swapAllow;
	}
	
	public void setSwap(Swap newSwap){
		this.swaps.add(newSwap);
	}
	
	
	@Override
	public String toString() {
		return "Pokemon name=" + name + ", type=" + type + ", number= "+ number;
	}


	public static void main(String[] args){
		Pokemon g = new Pokemon("Glumanda", Type.Fire);
		Pokemon s = new Pokemon("Shiggy", Type.Water);
		Pokemon sl = new Pokemon("Shillok", Type.Water);
		System.out.println(g);
		System.out.println(s);
		System.out.println(sl);
	}
}
