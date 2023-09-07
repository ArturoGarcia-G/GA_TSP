
package ga1.pkg1_tsp;
import java.util.*;


/**
 *
 * @author Arturo
 */
public class GA11_TSP {

    /**
     * @param args the command line arguments
     */
    public static int calificar(int[] travel)
    {
        double[][] Matriz ={
             
            {  0., 208., 132., 105., 369., 323., 344., 254., 404., 329., 104., 426., 202., 266., 173., 222., 191., 118., 197., 386., 203., 448., 383., 277., 372., 397., 301., 385., 165., 341., 351., 262., 331., 141., 381., 397., 445., 277., 394., 316.},
            {208.,   0., 228., 468., 393., 118., 150., 131., 125., 258., 387., 444., 129., 413., 248., 466.,  91., 464., 359.,  92., 282., 243., 150., 306., 127., 210., 403., 393., 298., 384., 343., 534., 249., 252., 317., 171., 435., 208., 123., 153.},
            {132., 228.,   0., 387., 225., 293., 335., 404., 309., 268., 424., 126., 346., 260., 380., 396., 358., 494., 308., 281.,  47., 501., 466., 289., 302., 469., 239., 530., 392., 136., 289., 477., 103., 298., 432., 147., 186., 427., 249., 306.},
            {105., 468., 387.,   0., 193., 466., 322., 144., 310., 359., 137., 126., 457., 176., 115., 253., 143., 362.,  45., 181., 187., 241.,  84.,  94., 370., 430., 577., 372., 557., 493., 145., 390., 256., 512., 272., 246., 277., 469., 420., 162.},
            {369., 393., 225., 193.,   0., 259., 336., 315., 264., 152., 217., 276., 217., 364., 173., 212., 434., 343., 164.,  92., 300., 336., 235., 498., 482., 517., 352., 182., 313., 233., 106., 379., 276., 411., 241., 363., 242., 387., 224., 344.},
            {323., 118., 293., 466., 259.,   0., 401., 271., 237., 287., 408.,  69., 164., 175., 299., 229., 332., 310.,  56., 340., 298., 402.,  59., 315., 236., 522., 150.,  78., 269., 547., 316., 106., 104., 108., 381., 304., 379., 329., 389., 171.},
            {344., 150., 335., 322., 336., 401.,   0., 367., 185., 373., 339., 395.,  49., 151., 564., 395., 387., 430., 318., 259., 318., 320., 342., 340., 426., 410., 217., 384., 226., 542., 279., 456., 405., 151., 351., 292., 332., 161., 375., 367.},
            {254., 131., 404., 144., 315., 271., 367.,   0., 298., 180., 102., 545., 356., 454., 479., 438., 299., 442., 179., 385., 477., 226., 344., 283., 465., 290., 221., 328., 280., 347., 449., 215., 150., 259., 321., 328., 432., 363., 475., 265.},
            {404., 125., 309., 310., 264., 237., 185., 298.,   0., 395., 486., 460., 309., 118., 119., 398., 210., 162., 230., 307., 333., 327.,  26., 551., 269., 522., 312., 241., 172., 238., 550., 250., 463., 365., 301., 354., 423., 245., 449., 454.},
            {329., 258., 268., 359., 152., 287., 373., 180., 395.,   0., 448., 362., 298., 540., 546., 305., 241., 418.,  98., 148.,  98., 531., 278., 237., 262., 424., 374., 240., 282., 290., 325., 119., 165., 196., 173., 192., 389., 286., 435., 508.},
            {104., 387., 424., 137., 217., 408., 339., 102., 486., 448.,   0.,  21., 432., 393., 427., 360., 276., 248., 306., 276., 190., 529., 364., 357., 433., 401., 282., 233., 296., 323., 307., 336., 389., 511., 376., 367., 309., 426., 243., 477.},
            {426., 444., 126., 126., 276.,  69., 395., 545., 460., 362.,  21.,   0., 161., 269., 397., 290., 234., 447., 311., 212., 191., 285., 414., 441., 298., 293., 401., 393., 365., 415., 285., 356., 376., 272., 299., 516., 288., 229., 140., 574.},
            {202., 129., 346., 457., 217., 164.,  49., 356., 309., 298., 432., 161.,   0., 454., 402., 189., 355., 140., 310., 173., 209., 322., 204., 376., 463., 227., 465., 189., 372., 151., 134., 363., 113., 362., 174., 404., 101., 365., 447., 186.},
            {266., 413., 260., 176., 364., 175., 151., 454., 118., 540., 393., 269., 454.,   0., 227., 479., 351., 361., 247., 525., 269., 261., 407., 342., 266., 458., 374., 372.,  93., 345., 115., 221., 397., 518., 117., 333., 432., 304., 255., 137.},
            {173., 248., 380., 115., 173., 299., 564., 479., 119., 546., 427., 397., 402., 227.,   0.,  80., 313., 241., 519., 362., 371., 202., 309., 209., 108., 400.,  86., 491., 342., 110., 189., 293., 444., 107., 318., 164., 317., 321.,  58., 423.},
            {222., 466., 396., 253., 212., 229., 395., 438., 398., 305., 360., 290., 189., 479.,  80.,   0., 210., 135., 295., 197., 210., 331., 376., 126., 317., 359., 523., 431., 109., 453., 466., 519.,  79., 244., 455., 467., 305., 263., 271., 271.},
            {191.,  91., 358., 143., 434., 332., 387., 299., 210., 241., 276., 234., 355., 351., 313., 210.,   0.,  69., 167., 213., 392., 472., 240., 168., 364., 361., 314., 270., 462., 186., 196., 229., 286., 159., 228., 267., 206., 272., 142.,  48.},
            {118., 464., 494., 362., 343., 310., 430., 442., 162., 418., 248., 447., 140., 361., 241., 135.,  69.,   0., 201., 241., 198., 172., 202., 201., 189., 456.,  96., 272., 154., 240., 428., 454., 315., 337., 179., 538., 353., 246., 423., 187.},
            {197., 359., 308.,  45., 164.,  56., 318., 179., 230.,  98., 306., 311., 310., 247., 519., 295., 167., 201.,   0.,  44.,  27., 169., 152., 514., 210., 355., 381., 402.,  65., 359., 523., 255., 217., 284., 518., 354., 410., 328., 206., 349.},
            {386.,  92., 281., 181.,  92., 340., 259., 385., 307., 148., 276., 212., 173., 525., 362., 197., 213., 241.,  44.,   0., 453., 353., 289., 304., 188., 415., 172., 297., 424., 291., 308., 161., 271., 381., 364., 307., 351., 254., 123., 505.},
            {203., 282.,  47., 187., 300., 298., 318., 477., 333.,  98., 190., 191., 209., 269., 371., 210., 392., 198.,  27., 453.,   0., 504., 283., 368., 421., 288., 340.,  94., 346., 174., 478., 590., 224., 426., 325., 341., 266., 114., 539., 141.},
            {448., 243., 501., 241., 336., 402., 320., 226., 327., 531., 529., 285., 322., 261., 202., 331., 472., 172., 169., 353., 504.,   0., 205., 301., 334., 375., 405., 432., 471., 191., 546., 515., 245., 462., 468., 325., 177., 216., 333., 309.},
            {383., 150., 466.,  84., 235.,  59., 342., 344.,  26., 278., 364., 414., 204., 407., 309., 376., 240., 202., 152., 289., 283., 205.,   0.,  68., 180., 483., 384., 273., 281., 256.,  73., 326., 280., 467., 409., 174., 348., 228.,  46., 272.},
            {277., 306., 289.,  94., 498., 315., 340., 283., 551., 237., 357., 441., 376., 342., 209., 126., 168., 201., 514., 304., 368., 301.,  68.,   0., 111., 448., 345., 500., 110., 421., 160., 254., 183., 329., 160., 137., 419., 384., 327., 355.},
            {372., 127., 302., 370., 482., 236., 426., 465., 269., 262., 433., 298., 463., 266., 108., 317., 364., 189., 210., 188., 421., 334., 180., 111.,   0., 436., 380., 373., 344., 135., 268., 482., 196., 129., 122., 325., 281., 242., 243., 108.},
            {397., 210., 469., 430., 517., 522., 410., 290., 522., 424., 401., 293., 227., 458., 400., 359., 361., 456., 355., 415., 288., 375., 483., 448., 436.,   0., 149., 283., 347., 501., 197., 363., 395., 314., 503., 230., 305., 268., 266., 279.},
            {301., 403., 239., 577., 352., 150., 217., 221., 312., 374., 282., 401., 465., 374.,  86., 523., 314.,  96., 381., 172., 340., 405., 384., 345., 380., 149.,   0.,  94., 175., 279., 177., 418., 343., 445., 285., 352., 388., 344., 532., 128.},
            {385., 393., 530., 372., 182.,  78., 384., 328., 241., 240., 233., 393., 189., 372., 491., 431., 270., 272., 402., 297.,  94., 432., 273., 500., 373., 283.,  94.,   0., 372.,  97., 413., 321., 178., 241., 397., 180., 318., 500., 420., 109.},
            {165., 298., 392., 557., 313., 269., 226., 280., 172., 282., 296., 365., 372.,  93., 342., 109., 462., 154.,  65., 424., 346., 471., 281., 110., 344., 347., 175., 372.,   0., 161., 132., 439., 110., 425., 313., 222., 308., 398., 223., 401.},
            {341., 384., 136., 493., 233., 547., 542., 347., 238., 290., 323., 415., 151., 345., 110., 453., 186., 240., 359., 291., 174., 191., 256., 421., 135., 501., 279.,  97., 161.,   0., 297., 455.,  28., 327., 194., 374., 436., 134., 193., 265.},
            {351., 343., 289., 145., 106., 316., 279., 449., 550., 325., 307., 285., 134., 115., 189., 466., 196., 428., 523., 308., 478., 546.,  73., 160., 268., 197., 177., 413., 132., 297.,   0., 134., 295., 262., 551., 257., 307., 352., 152., 364.},
            {262., 534., 477., 390., 379., 106., 456., 215., 250., 119., 336., 356., 363., 221., 293., 519., 229., 454., 255., 161., 590., 515., 326., 254., 482., 363., 418., 321., 439., 455., 134.,   0., 306.,  99., 145., 359., 416., 332., 522., 157.},
            {331., 249., 103., 256., 276., 104., 405., 150., 463., 165., 389., 376., 113., 397., 444.,  79., 286., 315., 217., 271., 224., 245., 280., 183., 196., 395., 343., 178., 110.,  28., 295., 306.,   0., 311.,  94., 498., 185., 351., 236., 328.},
            {141., 252., 298., 512., 411., 108., 151., 259., 365., 196., 511., 272., 362., 518., 107., 244., 159., 337., 284., 381., 426., 462., 467., 329., 129., 314., 445., 241., 425., 327., 262.,  99., 311.,   0., 391., 360., 515., 553., 349., 263.},
            {381., 317., 432., 272., 241., 381., 351., 321., 301., 173., 376., 299., 174., 117., 318., 455., 228., 179., 518., 364., 325., 468., 409., 160., 122., 503., 285., 397., 313., 194., 551., 145.,  94., 391.,   0., 362., 178.,  63., 413., 367.},
            {397., 171., 147., 246., 363., 304., 292., 328., 354., 192., 367., 516., 404., 333., 164., 467., 267., 538., 354., 307., 341., 325., 174., 137., 325., 230., 352., 180., 222., 374., 257., 359., 498., 360., 362.,   0.,  70., 382., 333., 195.},
            {445., 435., 186., 277., 242., 379., 332., 432., 423., 389., 309., 288., 101., 432., 317., 305., 206., 353., 410., 351., 266., 177., 348., 419., 281., 305., 388., 318., 308., 436., 307., 416., 185., 515., 178.,  70.,   0., 289., 106., 308.},
            {277., 208., 427., 469., 387., 329., 161., 363., 245., 286., 426., 229., 365., 304., 321., 263., 272., 246., 328., 254., 114., 216., 228., 384., 242., 268., 344., 500., 398., 134., 352., 332., 351., 553.,  63., 382., 289.,   0., 267., 557.},
            {394., 123., 249., 420., 224., 389., 375., 475., 449., 435., 243., 140., 447., 255.,  58., 271., 142., 423., 206., 123., 539., 333.,  46., 327., 243., 266., 532., 420., 223., 193., 152., 522., 236., 349., 413., 333., 106., 267.,   0., 477.},
            {316., 153., 306., 162., 344., 171., 367., 265., 454., 508., 477., 574., 186., 137., 423., 271.,  48., 187., 349., 505., 141., 309., 272., 355., 108., 279., 128., 109., 401., 265., 364., 157., 328., 263., 367., 195., 308., 557., 477.,   0.}
        };
        int result = 0;
        for (int i = 0; i <39; i++) {
            result += Matriz[travel[i]][travel[i+1]];
          
        }
        result += Matriz[travel[39]][travel[0]];
        
        return result;
        
    }
    
     // Función para intercambiar dos elementos del arreglo
    static void swap(int[] arreglo, int[][] padres, int i, int j) {
        
        int [] padretemp;
        padretemp = new int[40];
        
        int temp = arreglo[i];
        padretemp = padres[i];
        arreglo[i] = arreglo[j];
        padres[i] = padres[j];
        arreglo[j] = temp;
        padres[j] = padretemp;
    }

    /* Esta función toma el último elemento como pivote, 
    coloca el pivote en su posición correcta en el arreglo 
    ordenado y coloca los elementos menores que el pivote a su izquierda 
    y los elementos mayores que el pivote a su derecha */
    static int partition(int[] arreglo,int[][] padres, int low, int high) {
        int pivot = arreglo[high]; // pivote
        int i = (low - 1); // índice del elemento más pequeño

        for (int j = low; j <= high - 1; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arreglo[j] <= pivot) {
                i++; // Incrementa el índice del elemento más pequeño
                swap(arreglo,padres, i, j);
            }
        }
        swap(arreglo,padres, i + 1, high);
        return (i + 1);
    }

    /* Función principal que implementa el algoritmo QuickSort 
    arreglo[] --> Arreglo a ordenar 
    low --> índice inicial 
    high --> índice final */
    static void quickSort(int[] arreglo, int[][] padres,int low, int high) {
        if (low < high) {
            /* pi es el índice de partición, arreglo[pi] está en su posición correcta */
            int pi = partition(arreglo,padres, low, high);

            /* Ordena los elementos antes de la partición y después de la partición */
            quickSort(arreglo, padres, low, pi - 1);
            quickSort(arreglo, padres, pi + 1, high);
        }
    }

    
    
    public static int[] seleccionarPadres()
    {
        int[] numeros = new int[800];

        // Llenar el arreglo con los números del 1 al 
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i;
        }

        // Ordenar aleatoriamente el arreglo
        Random random = new Random();
        for (int i = numeros.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = temp;
        }

        
        
        return numeros;
        
    
    }
    public static int numeroAleatorio(int min, int max) {
        Random rand = new Random();        
        int numero = rand.nextInt((max - min) + 1) + min; // Generar primer número aleatorio
        return numero;
    }
    
    public static int[] crossover(int[] parent1, int[] parent2) {
        Random rand = new Random();
        
        // Elegir dos puntos de corte aleatorios
        int cutpoint1 = rand.nextInt(38) + 1;
        int cutpoint2 = rand.nextInt(38) + 1;
        
        // Asegurarse de que cutpoint2 > cutpoint1
        if (cutpoint2 < cutpoint1) {
            int temp = cutpoint1;
            cutpoint1 = cutpoint2;
            cutpoint2 = temp;
        }
        
        // Crear un nuevo arreglo hijo
        int[] child = new int[40];
        Arrays.fill(child, -1);
        
        // Copiar los genes entre los puntos de corte
        for (int i = cutpoint1; i < cutpoint2; i++) {
            child[i] = parent1[i];
        }
        
        // Recorrer los nodos restantes de cada padre
        int j = cutpoint2;
        for (int i = cutpoint2; i < 40 + cutpoint2; i++) {
            int index = i % 40;
            
            // Agregar nodos del padre 2 al hijo
            if (!contains(child, parent2[index])) {
                child[j] = parent2[index];
                j = (j + 1) % 40;
            }
        }
        
        return child;
    }
    
    private static boolean contains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
    public static int[] generarSolucion()
    {
        int[] numeros = new int[40];

        // Llenar el arreglo con los números del 1 al 40
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i;
        }

        // Ordenar aleatoriamente el arreglo
        Random random = new Random();
        for (int i = numeros.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = temp;
        }

        
        
        return numeros;
        
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[][] poblacionInicial;
        poblacionInicial = new int[1000][40];
        int[][] padres;
        padres = new int[800][40];
        int[][] hijos;
        hijos = new int[800][40];
        int [] costos;
        int [] padre1;
        int [] padre2;
        padre1 = new int[40];
        padre2 = new int[40];
        
        int [] hijo1;
        int [] hijo2;
        hijo1 = new int[40];
        hijo2 = new int[40];
        costos = new int[1000];
        
        
        int [] padresSelec;        
        padresSelec = new int[800];
        
        int p1, p2, n1, n2, probabilidad, r;
        
        // Crear una poblacion inicial de 1000 elementos
        int[] numeros= new int [40];
        int costo;
        for(int i=0; i<1000; i++){
            numeros = generarSolucion();
            poblacionInicial[i]= numeros;
            costo=calificar(numeros);
            costos[i]=costo;
        }
        //CICLO DE 100 GENERACIONES
        for(int m=0; m<100;m++){
            //Para imprimir el mejor resultado de cada generacion
            //System.out.println("generacion "+m+" Mejor: " +costos[0]);
            //System.out.println(m);
            for(int i=0; i<1000; i++){
                
                costo=calificar(poblacionInicial[i]);
                costos[i]=costo;
            }
            
        
        
        //Seleccion de padres 
        for(int x=0;x<800; x++ )
        {
            
            p1=numeroAleatorio(0,999);
            p2=numeroAleatorio(0,999);
            if(costos[p1]>=costos[p2])
            {
                padres[x]=poblacionInicial[p2];
            }
            else
            {
                padres[x]=poblacionInicial[p1];
            }
                
        }
        
        // Crossover (Creacion de hijos)
        padresSelec=seleccionarPadres(); //Se seleccionan aleatoriamente el orden de padres 
        for(int z=0;z<800;z=z+2)
        {
            probabilidad=numeroAleatorio(1,10);
            if(probabilidad>7)
            {
                n1=numeroAleatorio(0,39);
                n2=numeroAleatorio(0,39);
                hijo1=crossover(padres[padresSelec[z]], padres[padresSelec[z+1]]);
                hijo2=crossover(padres[padresSelec[z+1]], padres[padresSelec[z]]);
                  
                int aux;
                aux=hijo1[n1];
                hijo1[n1]=hijo1[n2];
                hijo1[n2]=aux;
                aux=hijo2[n1];
                hijo2[n1]=hijo2[n2];
                hijo2[n2]=aux;
                hijos[z]=hijo1;
                hijos[z+1]=hijo2;
                
            }
            else
            {
               hijos[z]=crossover(padres[padresSelec[z]], padres[padresSelec[z+1]]);
                hijos[z+1]=crossover(padres[padresSelec[z+1]], padres[padresSelec[z]]); 
            }
            
        }
        //PARA MOSTRAR LAS TABLAS
        /*
        for(int i = 0; i < poblacionInicial.length; i++) {
            for (int j = 0; j < poblacionInicial[i].length; j++) {
                System.out.print(poblacionInicial[i][j] + " ");
            }
            System.out.println(); // Agregar un salto de línea después de cada fila
            System.out.println("-----"+i);
        }
        
        System.out.println("Generacion principal");
        System.out.println(Arrays.toString(costos));
        */
        quickSort(costos, poblacionInicial, 0, 999);
        
        for(int p=0; p<800;p++)
        {
            poblacionInicial[199+p]=hijos[p];
            
        }
        
        
        
        }
        System.out.println("Resultado:");
       System.out.println(costos[0]);       
       System.out.println("Mejor arreglo");
       System.out.println(Arrays.toString(poblacionInicial[0]));     
    }
    
    
}
