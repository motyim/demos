package me.motyim.learn.fluentapi.impl;

import me.motyim.learn.fluentapi.contract.IItem;
import me.motyim.learn.fluentapi.contract.IMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 10-Dec-17
 */
public class ArsalanMenuHandler implements IMenu {

    List<IItem> menuList = new ArrayList<>();
    List<IItem> selectedList = new ArrayList<>();

    public ArsalanMenuHandler()
    {
        IItem biriyani = new IItem(){
            public IItem name()
            {
                System.out.println("Mutton Biriyani");
                return this;
            }
            public Integer cost()
            {
                return 180;
            }
        };
        IItem muttonChap = new IItem(){
            public IItem name()
            {
                System.out.println("Mutton Chap");
                return this;
            }
            public Integer cost()
            {
                return 160;
            }
        };
        IItem firni = new IItem(){
            public IItem name()
            {
                System.out.println("Firni");
                return this;
            }
            public Integer cost()
            {
                return 100;
            }
        };
        menuList.add(biriyani);
        menuList.add(muttonChap);
        menuList.add(firni);
    }

    @Override
    public IMenu order(int index) {

        IItem item = menuList.get(index);
        selectedList.add(item);
        System.out.println("Order given ::");
        item.name();
        return this;
    }

    @Override
    public IMenu eat() {
        for(IItem item : selectedList)
        {
            System.out.println("eating ");
            item.name();
        }
        return this;
    }

    @Override
    public IMenu pay() {
        int cost=0;
        for(IItem item : selectedList)
        {
            cost += item.cost();
        }
        System.out.println("Paying Rupees" + cost);
        return this;
    }

    @Override
    public IItem get(int index) {
        if(index <3)
        {
            return menuList.get(index);
        }
        return null;
    }


    public void showMenu(){
        System.out.println("MENU IN ARSALAN");
        for(IItem item : menuList)
        {
            item.name();
        }
    }

}
