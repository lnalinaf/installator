package installator.stages.config;

/**
 * Панель ответа на вопрос по умолчанию. Используется по умолчанию для
 * графического интерфейса {@link StringStage}
 *
 * @author alina
 */
class StringPanel extends StagePanel<String> {

    private javax.swing.GroupLayout layout;
    private javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    private javax.swing.GroupLayout.SequentialGroup buttonHorizontalGroup;
    private javax.swing.GroupLayout.SequentialGroup allHorizontalGroup;
    private javax.swing.GroupLayout.ParallelGroup buttonVertcalGroup;
    private javax.swing.GroupLayout.SequentialGroup allVertcalGroup;
    private final int UP_LABEL_GAP = 110;
    private final int DOWN_TEXT_GAP = 108;
    private final int WIDTH_BUTTON = 88;
    private final int HEIGHT_BUTTON = 25;
    private final int LEFT_BUTTON_GAP = 92;

    /**
     * Создание панельки по умолчанию
     *
     * @param index Индефикатор
     * @param name имя
     * @param text текст вопроса
     * @param defaultAnswer путь по умолчанию
     */
    StringPanel(int index, String name, String text, String defaultAnswer) {
        super();
        myInit();
       // setName(name);
        jLabel1.setText(text);
        jTextField1.setText(defaultAnswer);
        initComponents();
    }

    private void fillButtonGroup() {
        buttonHorizontalGroup
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, LEFT_BUTTON_GAP, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
                .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton3)
                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING));
        buttonVertcalGroup
                .addComponent(jButton3)
                .addComponent(jButton2)
                .addComponent(jButton1);
    }

    private void fillAllGroup() {
        allVertcalGroup
                .addContainerGap(UP_LABEL_GAP, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton4)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(DOWN_TEXT_GAP, DOWN_TEXT_GAP, DOWN_TEXT_GAP)
                .addGroup(buttonVertcalGroup)
                .addContainerGap();
        allHorizontalGroup
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1)
                .addGroup(buttonHorizontalGroup))
                .addContainerGap();
    }

    private void myInit() {/*
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

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

        jButton4.setText("Обзор");
        jButton4.setMaximumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton4.setMinimumSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton4.setPreferredSize(new java.awt.Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jLabel1.setText("Ляляля?");
        jTextField1.setText("C:/");
        jTextField1.setEditable(false);

        layout = new javax.swing.GroupLayout(this);
        buttonHorizontalGroup = layout.createSequentialGroup();
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
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allVertcalGroup));*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {/*

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jLabel1.setText("jLabel1");

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton3))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(22, 22, 22))
        );*/
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cancelListener.panelCanceled(this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fileChooser.setFileSelectionMode(fileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showOpenDialog(null) != fileChooser.APPROVE_OPTION) {
            return;
        }
        jTextField1.setText(fileChooser.getSelectedFile().getParent() + '/'
                + fileChooser.getSelectedFile().getName());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        backListener.panelReverted(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        calcData();
        nextListener.panelComplited(this);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void calcData() {
        data = jTextField1.getText();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;

    @Override
    protected void init() {

    }
    // End of variables declaration//GEN-END:variables
}
