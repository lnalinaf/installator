package installator.stages.config;

/**
 * Панель ответа на вопрос по умолчанию. Используется по умолчанию для графического 
 * интерфейса {@link StringStage}
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
     * @param index Индефикатор
     * @param name имя
     * @param text текст вопроса
     * @param defaultAnswer путь по умолчанию
     */
    StringPanel(int index, String name, String text, String defaultAnswer) {
        super(index);
         myInit();
        initComponents();
    }
    
    private void myInit() {
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jLabel1.setText("Ляляля?");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jTextField1.setText("jTextField1");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(42, 42, 42)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
