import java.lang.Object;

public class Documentation2{
  // attribut
  private Integer bit;
  public Documentation2() {
    this.bit = 0;
  }
  // méthode
  public String Base() {
      int ent=this.bit;
      Integer nombre=Integer.parseInt("0");
      String binaire="";
      String hexa="";
      int numero=0;
      int multi=1;
      int k=0;
      while(ent>=10){
	  binaire=nombre.toBinaryString(ent%10)+binaire;
	  if(ent%10==2 || ent%10==3){
	       binaire="0"+binaire;
	  }
	  if(ent%10==0 || ent%10==1){
	       binaire="00"+binaire;
	  }
	  ent=ent/10;
      }
      binaire=nombre.toBinaryString(ent%10)+binaire;
      System.out.println(binaire);
      for(k=binaire.length();k>=4;k=k-4){
	  for(int i=0;i<4;i++){
	      if(binaire.charAt(k-i-1)=='1'){
		  for(int j=i;j>0;j--){
		      multi=multi*2;
		  }
		  numero=numero+multi;
		  multi=1;
	      }
	  }
	  hexa=Integer.toHexString(numero)+hexa;
	  numero=0;
      }
      for(int i=0;i<k;i++){
	      if(binaire.charAt(k-i-1)=='1'){
		   System.out.println("oui");
		  for(int j=i;j>0;j--){
		      multi=multi*2;
		  }
		  numero=numero+multi;
		  multi=1;
	      }
	  }
      if (numero!=0){
	  hexa=Integer.toHexString(numero)+hexa;
      }
      return hexa;
  }
  public static void main(String[] args) {
    Documentation2 k= new Documentation2();
    String nombre = args[0];
    k.bit = Integer.parseInt(nombre);
    System.out.println(k.Base());
  }
}
