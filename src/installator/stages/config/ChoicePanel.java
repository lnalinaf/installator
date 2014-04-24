package installator.stages.config;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JRadioButton;

/**
 * Панель единичного выбора из списка по умолчанию. Используется по умолчанию
 * для графического интерфейса {@link ChoiceStage}
 *
 * @author alina
 */
class ChoicePanel extends StagePanel<Integer> {

    javax.swing.GroupLayout layout;
    private javax.swing.GroupLayout.SequentialGroup buttonHorizontalGroup;
    private javax.swing.GroupLayout.ParallelGroup radioHorizontalGroup;
    private javax.swing.GroupLayout.SequentialGroup allHorizontalGroup;
    private javax.swing.GroupLayout.ParallelGroup buttonVertcalGroup;
    private javax.swing.GroupLayout.SequentialGroup allVertcalGroup;
    private final int LEFT_BUTTON_GAP = 101;
    private final int WIDTH_BUTTON = 88;
    private final int HEIGHT_BUTTON = 25;
    private final JRadioButton[] radioButtons;

    ChoicePanel(int index, String name, String text,
            String[] radioButtonsText) {
        super();
        radioButtons = new JRadioButton[radioButtonsText.length];
        myInit(radioButtonsText);
       // setName(name);
        jLabel1.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Выберите вариант установки:");

        jButton1.setText("Назад");
        jButton1.setMaximumSize(new java.awt.Dimension(88, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(88, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(88, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Далее");
        jButton2.setMaximumSize(new java.awt.Dimension(88, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(88, 25));
        jButton2.setPreferredSize(new java.awt.Dimension(88, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Отмена");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

       /* javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 101, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );*/
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        backListener.panelReverted(this);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        calcData();
        nextListener.panelComplited(this);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        cancelListener.panelCanceled(this);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void calcData() {
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isSelected()) {
                data = new Integer(i);
            }
        }

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

    private void fillAllGroup() {/*
        AbstractButton radBut;
        radioHorizontalGroup
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonHorizontalGroup);
        allVertcalGroup
                .addContainerGap()
                .addComponent(jLabel1);
        Enumeration<AbstractButton> en = buttonGroup1.getElements();
        int i = 0;
        while (en.hasMoreElements()) {
            radBut = en.nextElement();
            radioHorizontalGroup.addComponent(radBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            allVertcalGroup
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(radBut);
        }
        allVertcalGroup
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(buttonVertcalGroup)
                .addContainerGap();
        allHorizontalGroup
                .addContainerGap()
                .addGroup(radioHorizontalGroup)
                .addContainerGap();*/
    }

    private void myInit(String[] radioButtonsText) {/*
        buttonGroup1 = new javax.swing.ButtonGroup();
        for (int i = 0; i < radioButtonsText.length; i++) {
            radioButtons[i] = new JRadioButton();
            radioButtons[i].setText(radioButtonsText[i]);
            buttonGroup1.add(radioButtons[i]);
        }
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("Назад");
        jButton1.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton1.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton1.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Далее");
        jButton2.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton2.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton2.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Отмена");
        jButton3.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton3.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton3.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
                .addGroup(allVertcalGroup));*/
    }

    @Override
    protected void init() {

    }
}
