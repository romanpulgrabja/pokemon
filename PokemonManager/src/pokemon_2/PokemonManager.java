package pokemon_2;


public class PokemonManager {
	
	



	public static void main(String[] args){
		
		/*
		Trainer Roman = new Trainer("Roman", "Pulgrabja");
		manager.addTrainer(Roman, "Roman", "Pulgrabja");
		Trainer Johanna = new Trainer("Johanna", "Kinkela");
		manager.addPokemon(Johanna, "Glumanda", Type.Fire);
		System.out.println(manager);
		*/
		Trainer Ash;
		Ash = new Trainer("Ash", "Katchum");
		Trainer Roman = new Trainer("Roman", "Pulgrabja");
		Pokemon Glumanda = new Pokemon("Glumande", Type.Fire);
		Pokemon Shiggy = new Pokemon("Shiggy", Type.Water);
		Pokemon Sleima = new Pokemon("Sleima", Type.Poison);
		Pokemon Sleimog = new Pokemon("Sleimog", Type.Poison);
		Roman.setPokemon(Glumanda);
		Roman.setPokemon(Sleima);
		System.out.println(Roman);
		Ash.setPokemon(Shiggy);
		Ash.setPokemon(Glumanda);
		System.out.println(Ash);
		Roman.setPokemon(Sleimog);
		Roman.allPoison();
		Roman.allPokemon();
		Swap sw1 = new Swap(Shiggy, Sleima);
		sw1.execute();
		Shiggy.setSwapStatus(false);
		Swap sw2 = new Swap(Shiggy, Sleima);
		sw2.execute();
		Swap sw3 = new Swap(Sleima, Sleimog);
		sw3.execute();
		Swap sw4 = new Swap(Sleima, Glumanda);
		sw4.execute();
	}
}
