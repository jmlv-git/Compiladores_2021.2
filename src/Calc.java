import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calc {

	public static void calcu(Stack pilha) {
		if(pilha.capacity()==1) {
			String result = (String) pilha.pop();
			//a pilha fica so com o resultado
		}else {
			String cell = (String) pilha.pop();
			boolean eNum =  true;
			try {
		        Double.parseDouble(cell);
		        //n faz nada pois eNum ja e true
		        }catch(NumberFormatException e) {
		            eNum=false;
		        }
			
			if (!eNum) {//pop em um operador
				if (cell.equals("+")) {
					calcu(pilha);
					double pop1 = Double.parseDouble((String)pilha.pop());
					calcu(pilha);
					double pop2 = Double.parseDouble((String)pilha.pop());
					double result = pop1+pop2;
					pilha.push(Double.toString(result));
	
				}else if (cell.equals("-")) {
					calcu(pilha);
					double pop1 = Double.parseDouble((String)pilha.pop());
					calcu(pilha);
					double pop2 = Double.parseDouble((String)pilha.pop());
					double result = pop2-pop1;
					pilha.push(Double.toString(result));
				}else if (cell.equals("*")) {
					calcu(pilha);
					double pop1 = Double.parseDouble((String)pilha.pop());
					calcu(pilha);
					double pop2 = Double.parseDouble((String)pilha.pop());
					double result = pop1*pop2;
					pilha.push(Double.toString(result));
				}else {
					calcu(pilha);
					double pop1 = Double.parseDouble((String)pilha.pop());
					calcu(pilha);
					double pop2 = Double.parseDouble((String)pilha.pop());
					double result = pop2/pop1;
					pilha.push(Double.toString(result));
				}
			}else {//pop em um número
				pilha.push(cell);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
// usando Scanner para ler entrada	
//		Scanner in = new Scanner (System.in);
//		
//		Stack pilha = new Stack();
//		
//		while(in.hasNext()) {
//			String aux = in.nextLine();
//			pilha.push(aux);
//		}
//		calcu(pilha);
//		System.out.println(pilha.pop());
		
// lendo entrada de um arquivo			
		 Path path = Path.of("src/Calc1.stk");
	     String content = new String(Files.readAllBytes(path));
	     StringTokenizer st = new StringTokenizer(content, "\r\n");
	     Stack pilha = new Stack();
		
	     
	     while (st.hasMoreTokens()) {
	            String token = st.nextToken();
	            pilha.push(token);
	        }
	     calcu(pilha);
	     System.out.println(pilha.pop());
	     
	}

}
