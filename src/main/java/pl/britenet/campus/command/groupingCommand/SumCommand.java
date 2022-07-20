package pl.britenet.campus.command.groupingCommand;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;

import java.util.Scanner;

public class SumCommand extends Command {

    public SumCommand() {

        super(Constants.COMMAND_ADD);
    }


    @Override
    public void execute() {
        System.out.println("Podaj 2 liczby ");

        {
            Scanner scan = new Scanner(System.in);
            System.out.println("podaj a ");
            int a = scan.nextInt();
            System.out.println("podaj b ");
            int b = scan.nextInt();
            int suma = a + b;

            System.out.println(suma);
        }

    }
}


