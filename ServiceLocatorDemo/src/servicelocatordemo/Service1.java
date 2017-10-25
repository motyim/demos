/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicelocatordemo;

/**
 *
 * @author MY-PC
 */
public class Service1  implements Service{

    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Service One Execute");
    }
    
}
