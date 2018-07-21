/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Aeon(Ankit RudrAshokJha)
 */
public class AdDmnt extends ListDepartment{
    
    public AdDmnt(int w, int h) {
        super(w, h);
    }
     @Override
    public void initUI(){

        enableButton(false);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        editAddPanel.setVisible(true);
        bannerPanel.setVisible(false);
        EditTitle.setText("Add New Department");
        
    }
    
}
