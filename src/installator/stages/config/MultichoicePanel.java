/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package installator.stages.config;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;

/**
 *
 * @author alina
 */
public class MultichoicePanel extends javax.swing.JPanel implements StagePanel<Integer[]> {

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
    private MultichoiceStage<Integer[]> stage;

    //TODO 
    // 1)сделать обработчик нажатия на кнопку, в котором вызвать метод 
    // stage.setData(getData());
    // 2)сделать метод setText который устанавливает переданный текст в метку
    /**
     * Creates new form MultichoicePanel
     */
    public MultichoicePanel(MultichoiceStage<Integer[]> stage, String name, String text,
            String[] checkBoxText) {
        checkBoxes = new JCheckBox[checkBoxText.length];
        myInit(checkBoxText);
        setName(name);
        jLabel1.setText(text);
        this.stage = stage;
    }

    public void TextLabel(String text) {
        jLabel1.setText(text);
    }

    private void fillButtonGroup() {
        buttonHorizontalGroup
                .addGap(0, LEFT_BUTTON_GAP, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
                //.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, WIDTH_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE);
        buttonVertcalGroup
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
                //.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
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
       // jButton3 = new javax.swing.JButton();



        jButton1.setText("Назад");
        jButton1.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton1.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton1.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));

        jButton2.setText("Далее");
        jButton2.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton2.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton2.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));

//        jButton3.setText("Отмена");
//        jButton3.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
//        jButton3.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
//        jButton3.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Выберите необходимые компоненты:");

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("jCheckBox1");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("jCheckBox2");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setText("jCheckBox3");

        jButton1.setText("Назад");
        jButton1.setMaximumSize(new java.awt.Dimension(88, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(88, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(88, 25));

        jButton2.setText("Далее");
        jButton2.setMaximumSize(new java.awt.Dimension(88, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(88, 25));
        jButton2.setPreferredSize(new java.awt.Dimension(88, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel1))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public Integer[] getData() {
        //Enumeration<AbstractButton> en = buttonGroup1.getElements();
        //int i = 0;
        //while(en.hasMoreElements()) {
        //if(en.nextElement().isSelected()) {
        //return new Integer(i)  
        //}
        // i++;
        return null;
        //TODO
        //сделать считывание данных. мы должны вернуть массив номеров чекбоксов, 
        //которые нажаты.
    }
}
