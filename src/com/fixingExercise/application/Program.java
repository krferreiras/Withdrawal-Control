package com.fixingExercise.application;
/*	Fazer um programa para ler os dados de uma conta bancária e depois realizar um 
*	saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer 
*	ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de 
*	saque da conta.
*/

//	Solução "Gambiarra" usando método que retorna String.

import java.util.Locale;
import java.util.Scanner;

import com.fixingExercise.model.entities.Account;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		try(Scanner sc = new Scanner(System.in)){
			
			System.out.println("===========================");
			System.out.println("Informe os dados da conta:");
			System.out.println("===========================");
			System.out.println();
			
			System.out.print("Número: ");
			int numberAccount = sc.nextInt();
			System.out.print("Titular: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Saldo inicial: R$ ");
			double balance = sc.nextDouble();
			System.out.print("Limite de saque: R$ ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(numberAccount, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Informe uma quantidade para saque: R$ ");
			double amount = sc.nextDouble();
			
			String error = account.validateWithdraw(amount);
			if (error != null) {
				System.out.println(error);
			}
			else {
				account.withdraw(amount);
				System.out.printf("Novo saldo: R$ %.2f", account.getBalance());
			}
			
			sc.close();
		}
	}
}
