package mesStrings;

public class MaString {
	private  char[] lesCaracteres;
	public String toString(){
		return new String(lesCaracteres);//convertit un tableau de caractères en une chaîne de caractères
		}
	public MaString(){
		lesCaracteres=new char[0]; 
		toString();
		}
	public MaString(char[] tab,int d, int f){
		int i,taille;
		taille=f-d;
		lesCaracteres=new char[taille];
		for (i=0;i<taille;i++) lesCaracteres[i]=tab[d+i];
		toString();
		}
	public MaString(MaString ms){
		int taille;
		taille=ms.lesCaracteres.length;
		//lesCaracteres(new char[ms.lesCaracteres.length]); 
		lesCaracteres=new char[taille];
		//for (i=0;i<ms.lesCaracteres.length;i++){lesCaracteres[i]=ms.lesCaracteres[i];}
		lesCaracteres=ms.lesCaracteres;
		toString();
		}

public int length(){
		return lesCaracteres.length;
}

public boolean isEmpty(){
	return length()==0;
}

public char charAt(int i){
	if (i<length()&& i>=0)return lesCaracteres[i]; else return 0;
}

public MaString substring(int d, int f){
	if (f>this.length()) f=this.length();
	if (d>this.length()) d=this.length();
	if (d<0)d=0;
	return new MaString(lesCaracteres,d,f);
}

public MaString substring(int d){
	//return new MaString(lesCaracteres,d,this.length());
	return this.substring(d,this.length());
}

public int compareTo(MaString ms){
	int i=-1;
	int min;
	// traitement d'une chaine vide
	if (ms.length()==0 && this.length()==0)  return 0;
	if (ms.length()==0 && this.length()!=0) return 1;
	if (ms.length()!=0 && this.length()==0) return -1;
	if (ms.length()<= this.length()) min=ms.length(); else min = this.length();
	// les deux chaînes ne sont pas vides
	// test des min-1 premiers caracteres des deux chaines
			do {
				i++;
				}
			while (i<min-1 && this.lesCaracteres[i]== ms.lesCaracteres[i]);
	//les deux chaînes sont de même longueur et leurs derniers caractères respectifs sont identiques
	if (i==this.length()-1 && i==ms.length()-1&& this.lesCaracteres[i]== ms.lesCaracteres[i]) return 0;
		//if ( this.lesCaracteres[ms.length()-1]== ms.lesCaracteres[ms.length()-1]) return 0;
			else
				if (this.lesCaracteres[i]>ms.lesCaracteres[i]) return 1;
				else
					return -1;
	
}

public boolean equals(MaString ms){
	return compareTo(ms)==0;
}

public boolean startsWith(MaString prefixe){
	if (prefixe.length()==0 || this.length()==0) return false; else
	return prefixe.equals(this.substring(0, prefixe.length()));
	}

public int indexOf (char c, int i){
	int j=-1;
	if (this.length()==0) return -1;
	if (i>=this.length()) return -1;
	do {
		j++;
		}
	while((this.lesCaracteres[i+j]!= c) && (i+j < this.length()-1));
	if (this.lesCaracteres[j+i]==c) return j+i; else return -1;
	}
	
public int indexOf (char c){
	return this.indexOf (c, 0);
	}

public MaString concat(MaString ms){
	char [] inter=new char[this.length()+ms.length()];
	int i=0;
	for (i=0;i<this.length();i++){inter[i]=this.lesCaracteres[i];}
	for (i=0;i<ms.length();i++){inter[i+this.length()]= ms.lesCaracteres[i];}
	return new MaString(inter,0,inter.length);
}
	
public static MaString valueOf(boolean b){
	char[] vrai={'t','r','u','e'};
	char[] faux={'f','a','l','s','e'};
	if (b==true) {return new MaString(vrai,0,vrai.length);}
	else 
	 {return new MaString(faux,0,faux.length);}
	}

public static MaString valueOf (char c){
	char [] tabc = new char[1];
	tabc[0]=c;
	return new MaString(tabc,0,1);
}

public static MaString valueOf (int i){
	int j,sig, s=i, d=0;
	if (i>0) sig=0; else {sig=-1;i=-i;}
	//recherche de la dimension du tableau d
	while (s!=0){ 
		d++;
		s=(int)s/10;
		//System.out.println("s ="+s +"d ="+d);//pour contrôle
		}
	if (sig==-1) d=d+1;
	char[] tab=new char[d];
	s=i;
	// remplissage du tableau par les restes des divisions successives par 10 du nombre initial et convertit en char
	//ajout du code unicode /u0000 correspondant à 48 en décimal (30 en hexa)
	if (sig==-1) tab[0]='-';
	j=d-1;
	while (s!=0){
		tab[j--]= (char) (48+ (s%10));
		s=s/10;
		//System.out.println("tab ["+(j+1)+"] = " + (tab[j+1]) );// pour contrôle
	}
		
	return new MaString(tab,0,tab.length);
}

public char[] getLesCaracteres() {
	return lesCaracteres;
}
public void setLesCaracteres(char[] lesCaracteres) {
	this.lesCaracteres = lesCaracteres;
}

public static void main(String [] args ){
	char [] tab={'a','b','c','d','e','f','1','2','3','4'};
	int d=1,f=9;
	MaString mastring0=new MaString();
	MaString mastring1=new MaString(tab,d,f);
	MaString mastring2=new MaString(mastring1);
	MaString mastring3=new MaString();
	MaString mastring4=new MaString();
	System.out.println("premier construceur chaine vide mastring0 \t"+mastring0);
	System.out.println("deuxième construceur mastring1\t"+ mastring1);
	System.out.println("3éme constructeur mastring2 \t"+mastring2);
	System.out.println("méthode : longeur de mastring2 = "+mastring2.length());
	System.out.println("méthode isEmpty \t"+mastring2.isEmpty());
	System.out.println("méthode isEmpty \t"+mastring0.isEmpty());
	System.out.println("méthode charAt\t"+mastring2.charAt(1));
	System.out.println("méthode charAt sur chaine vide \t"+mastring0.charAt(1));
	mastring3=mastring1.substring(d,f);
	System.out.println("sous chaine entre"+d+" et"+f +"\t"+mastring3);
	mastring3=mastring1.substring(3);
	System.out.println("sous chaine à partir de l'indice "+d+"\t"+mastring3);
	System.out.println(mastring3.compareTo(mastring2));
	System.out.println(mastring2.compareTo(mastring3));
	System.out.println(mastring3.compareTo(mastring3));
	System.out.println(mastring3.equals(mastring2));
	System.out.println(mastring2.equals(mastring1));
	System.out.println(mastring1);
	System.out.println(mastring2);
	System.out.println(mastring2.compareTo(mastring1));
	System.out.println(mastring1.startsWith(mastring3));
	System.out.println(mastring2.startsWith(mastring3));
	System.out.println(mastring3.startsWith(mastring3));
	System.out.println(mastring3.startsWith(mastring0));
	System.out.println(mastring0.startsWith(mastring2));
	System.out.println(mastring2.indexOf('x', 3));
	System.out.println(mastring2.indexOf('c', 3));
	System.out.println(mastring2.indexOf('c', 2));
	System.out.println(mastring2.indexOf('x'));
	System.out.println(mastring2.indexOf('c'));
	System.out.println(mastring0.indexOf('c'));
	System.out.println("concat");
	mastring4=mastring1.concat(mastring3);
	System.out.println(mastring4);
	mastring4=mastring1.concat(mastring2);
	System.out.println(mastring4);
	boolean b=mastring2.equals(mastring1);
	System.out.println(valueOf(b));
	b = !(mastring2.equals(mastring1));
	System.out.println(valueOf(b));
	System.out.println(valueOf('\u004f'));
	System.out.println(valueOf('\u0061'));
	System.out.println(valueOf('5'));
	System.out.println(valueOf(4782));
	System.out.println(valueOf(-4782));
}

}//fin de classe MaString


	