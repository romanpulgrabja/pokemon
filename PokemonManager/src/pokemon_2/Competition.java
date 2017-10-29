package pokemon_2;

public class Competition extends Swap {
	
	private double rand1;
	private double rand2;


	public Competition(Pokemon pokemona, Pokemon pokemonb){
		super(pokemona, pokemonb);
		this.rand1 =  java.lang.Math.random();
		this.rand2 =  java.lang.Math.random();
	}
	
	@Override
	public void execute(){
		if(this.pokemon1.getSwapStatus() && this.pokemon2.getSwapStatus()){
			if(this.pokemon1.getTrainer() != this.pokemon2.getTrainer() && this.pokemon1.getType() != this.pokemon2.getType()){
				Pokemon poke1 = this.trainer1.getPokemon(pokemon1);
				Pokemon poke2 = this.trainer2.getPokemon(pokemon2);
				if(poke1.getType() == Type.Poison){
					rand1 = rand1 + 0.5;
				}
				else if(poke1.getType() == Type.Water){
					rand1 = rand1 + 0.3;
				}
				if(poke2.getType() == Type.Poison){
					rand2 = rand2 + 0.5;
				}
				else if(poke2.getType() == Type.Water){
					rand2 = rand2 + 0.3;
				}
				poke1.setPower(rand1);
				poke2.setPower(rand2);
				if(poke1.getPower() > poke2.getPower()){
					trainer1.setPokemon(poke1);
					trainer1.setPokemon(poke2);
					poke1.setCompetitions(this);
					poke2.setCompetitions(this);
					System.out.println("The trainer " + trainer1.getLastname() + " has won this competition!");
				}
				else{
					trainer2.setPokemon(poke1);
					trainer2.setPokemon(poke2);
					poke1.setCompetitions(this);
					poke2.setCompetitions(this);
					System.out.println("The trainer " + trainer2.getLastname() + " has won this competition!");
				}
			}
			else{
				System.err.println("Pokemon from the same trainer or of the same type cannot fight!");
			}
		}else{
			System.err.println("Those Pokemon can't fight each ohter");
		}
	}
	
}
