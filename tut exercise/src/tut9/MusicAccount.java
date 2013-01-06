package tut9;
class MusicAccount {
	int creadits = 100;
	MusicAccount (){
		
	}
	MusicAccount (int newcreadits){
		creadits = newcreadits;
	}
	void addCreadit (int purchasedCreadits){
		creadits =+ purchasedCreadits;
	}
	void purchasedCreadit (int minutes){
		if (minutes==0){
			creadits =-50;
		}
		else {
			creadits =-1;
		}
	}
	int getCreadits (){
		return creadits;
	}
}
