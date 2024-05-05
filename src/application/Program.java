package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario1;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario1> listaf = new ArrayList<>();
		
		System.out.print("Quantas pessoas vc quer registrar na sua empresa? ");
		int n = sc.nextInt();	
		
		for (int i = 0; i < n; i ++) {
			System.out.println("Funcionario #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while(hasId(listaf, id)) {
				System.out.println("esse id ja existe, por favor digite novamente: ");
			}
			
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			System.out.println();
			
			Funcionario1 funcionario = new Funcionario1(id, nome, salario);
			
			listaf.add(funcionario);
			
		}
		
		System.out.println();
		
		System.out.print("Digite o id do funcionario que vai receber aumento: ");
		int aumento = sc.nextInt();
		
		Funcionario1 funcionario = listaf.stream().filter(x -> x.getId() == aumento).findFirst().orElse(null);
		
		if (funcionario == null) {
			System.out.println("esse id nao existe");
		} else {
			System.out.print("Digite a porcentagem: ");
			double porcentagem = sc.nextDouble();
			funcionario.aumentaSalario(porcentagem);
		}
		
		System.out.println();
		
		System.out.println("Lista de funcionarios: ");
		for (Funcionario1 func : listaf) {
			System.out.println(func);
		}
		
		
		sc.close();
		
	}
	
	public static boolean hasId(List<Funcionario1> listaf, int id) {
		Funcionario1 funcionario = listaf.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return funcionario != null;
	}

}
