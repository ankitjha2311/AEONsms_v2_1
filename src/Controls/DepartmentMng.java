/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public interface DepartmentMng {
    public int deactiveDepartment(int ID);
    public int editDepartment(String[] data);
    public int addDepartment(String[] data);
    public String removeDepartment(int ID);
    
}
