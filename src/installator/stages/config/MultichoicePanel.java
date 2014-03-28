/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package installator.stages.config;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

/**
 * Панель множественного выбора из списка по умолчанию.
 * @author alina
 */
public class MultichoicePanel extends StagePanel<Integer[]> {



    javax.swing.GroupLayout layout;
    private javax.swing.GroupLayout.SequentialGroup buttonHorizontalGroup;
    private javax.swing.GroupLayout.ParallelGroup radioHorizontalGroup;
    private javax.swing.GroupLayout.SequentialGroup allHorizontalGroup;
    private javax.swing.GroupLayout.ParallelGroup buttonVertcalGroup;
    private javax.swing.GroupLayout.SequentialGroup allVertcalGroup;
    private final int LEFT_BUTTON_GAP = 101;
    private final int WIDTH_BUTTON = 88;
    private final int HEIGHT_BUTTON = 25;
    private final JCheckBox[] checkBoxes;

    /**
     * Создается панелька по умолчанию. 
     * @param stage ссылка на стадию, которая содержит данную панельку.
     * @param name имя
     * @param text вопрос, на который должен ответить пользователь
     * @param radioButtonsText пункты списка
     */
    public MultichoicePanel(int index, String name, String text,
            String[] checkBoxText) {
        super(index);
        checkBoxes = new JCheckBox[checkBoxText.length];
        myInit(checkBoxText);
        setName(name);
        jLabel1.setText(text);
    }

    private void fillButtonGroup() {
        buttonHorizontalGroup
                .addGap(0, LEFT_BUTTON_GAP, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, WIDTH_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE);
        buttonVertcalGroup
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
    }

    private void fillAllGroup() {
        AbstractButton checkBox;
        radioHorizontalGroup
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonHorizontalGroup);
        allVertcalGroup
                .addContainerGap()
                .addComponent(jLabel1);
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBox = checkBoxes[i];
            radioHorizontalGroup.addComponent(checkBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            allVertcalGroup
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(checkBox);
        }
        allVertcalGroup
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(buttonVertcalGroup)
                .addContainerGap();
        allHorizontalGroup
                .addContainerGap()
                .addGroup(radioHorizontalGroup)
                .addContainerGap();
    }

    private void myInit(String[] checkBoxText) {
        for (int i = 0; i < checkBoxText.length; i++) {
            checkBoxes[i] = new JCheckBox();
            checkBoxes[i].setText(checkBoxText[i]);
        }
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("Назад");
        jButton1.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton1.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton1.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));

        jButton2.setText("Далее");
        jButton2.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton2.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton2.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));

        jButton3.setText("Отмена");
        jButton3.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton3.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton3.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));

        layout = new javax.swing.GroupLayout(this);
        buttonHorizontalGroup = layout.createSequentialGroup();
        radioHorizontalGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        allHorizontalGroup = layout.createSequentialGroup();

        buttonVertcalGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        allVertcalGroup = layout.createSequentialGroup();

        fillButtonGroup();
        fillAllGroup();
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(allHorizontalGroup));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(allVertcalGroup));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    /**
     * Возварщает номера выбраных элементов списка.
     * @return номера выбраных элементов списка
     */
    public void calcData() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < checkBoxes.length; i++) {
            if(checkBoxes[i].isSelected())
                list.add(i);
        }
        data = (Integer[])list.toArray();

    }
}
