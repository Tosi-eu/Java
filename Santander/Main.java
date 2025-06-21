package Santander;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        String ip = scanner.nextLine(); 
        scanner.close(); 

      boolean isValidIp = validarIP(ip);

        if(isValidIp) {
                System.out.println("ip valido");
        } else {
            System.out.println("ip invalido");
        }
    }

    // Método para validar um endereço IP
    public static boolean validarIP(String ip) {
       String[] splittedIp = ip.split("\\."); 
        
       System.out.println(splittedIp.length);
        if(splittedIp.length != 4) return false;

        for (String ipShard : splittedIp) {
            boolean  isValidShard = ehNumeroValido(ipShard);
            if(!isValidShard) return false;
        }
        return true;
    }
    private static boolean ehNumeroValido(String str) {
        try {
            int num = Integer.parseInt(str); 
            return num >= 0 && num <= 255; 
        } catch (NumberFormatException e) {
            return false; 
        }
    }
}
