/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public interface ExtraCurricularMng {
    public int addExtraCurricular(String[] data);
    public int removeExtraCurricular(int ID);
    public int deactiveExtraCurricular(int ID);
    public int editExtraCurricular(String[] data);
}
