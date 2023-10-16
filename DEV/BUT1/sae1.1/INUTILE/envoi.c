for(;flag!=0;){
      if (SourisCliquee()==1){
         SourisPosition();
         if (_X>=400 && _X<=600 && _Y>=900 && _Y<=950){
            return 4;
         }
         if (_X>=50 && _X<=100 && _Y>=50 && _Y<=100){
            return 3;
         }
         if (_X>=150 && _X<=200 && _Y>=50 && _Y<=100){
            return 2;
         }
         if (_X>=250 && _X<=300 && _Y>=50 && _Y<=100){
            return 1;
         }
      }
   }