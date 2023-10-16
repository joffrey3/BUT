//Fouché Joffrey

public class Main {
    public static void main(String[] args) {
        Doublon doublon= new Doublon();
        int nb_doublon=0;
        boolean possible;
        for(int i=0;i<args.length;i++){
            possible=doublon.ajouter(Integer.parseInt(args[i]));
            if(!possible){
                nb_doublon=1;
            }
        }
        if(nb_doublon==1){
            System.out.println("doublon présent");
        }else{
            System.out.println("doublon non présent");
        }
    }
}
