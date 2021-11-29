/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author asus
 */
interface IDao {
    public void create();
    
    public void getList();   
    
    public void delete(String id);
    
    public void search();
    
    public void sort();
    
}
