import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
    JLabel l = new JLabel();
    JRadioButton[] jb = new JRadioButton[5];
    JButton b1;
    JButton b2;
    ButtonGroup bg;
    int count = 0;
    int current = 0;
    int x = 1;
    int y = 1;
    int now = 0;
    int[] m = new int[10];

    OnlineTest(String var1) {
        super(var1);
        this.setLayout(null);
        this.add(this.l);
        this.bg = new ButtonGroup();

        for (int var2 = 0; var2 < 5; ++var2) {
            this.jb[var2] = new JRadioButton();
            this.add(this.jb[var2]);
            this.bg.add(this.jb[var2]);
        }

        this.b1 = new JButton("Selanjutnya");
        this.b2 = new JButton("Bookmark");
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.add(this.b1);
        this.add(this.b2);
        this.set();
        this.l.setBounds(30, 40, 450, 20);
        this.jb[0].setBounds(50, 80, 100, 20);
        this.jb[1].setBounds(50, 110, 100, 20);
        this.jb[2].setBounds(50, 140, 100, 20);
        this.jb[3].setBounds(50, 170, 100, 20);
        this.b1.setBounds(100, 240, 100, 30);
        this.b2.setBounds(270, 240, 100, 30);
        this.setDefaultCloseOperation(3);
        this.setLayout((LayoutManager) null);
        this.setLocation(250, 100);
        this.setVisible(true);
        this.setSize(600, 350);
    }

    public void actionPerformed(ActionEvent var1) {
        if (var1.getSource() == this.b1) {
            if (this.check()) {
                ++this.count;
            }

            ++this.current;
            this.set();
            if (this.current == 9) {
                this.b1.setEnabled(false);
                this.b2.setText("Hasil");
            }
        }

        if (var1.getActionCommand().equals("Bookmark")) {
            JButton var2 = new JButton("Bookmark" + this.x);
            var2.setBounds(480, 20 + 30 * this.x, 100, 30);
            this.add(var2);
            var2.addActionListener(this);
            this.m[this.x] = this.current;
            ++this.x;
            ++this.current;
            this.set();
            if (this.current == 9) {
                this.b2.setText("Hasil");
            }

            this.setVisible(false);
            this.setVisible(true);
        }

        int var4 = 0;

        for (int var3 = 1; var4 < this.x; ++var3) {
            if (var1.getActionCommand().equals("Bookmark" + var3)) {
                if (this.check()) {
                    ++this.count;
                }

                this.now = this.current;
                this.current = this.m[var3];
                this.set();
                ((JButton) var1.getSource()).setEnabled(false);
                this.current = this.now;
            }

            ++var4;
        }

        if (var1.getActionCommand().equals("Hasil")) {
            if (this.check()) {
                ++this.count;
            }

            ++this.current;
            JOptionPane.showMessageDialog(this, "Jawaban Benar=" + this.count);
            System.exit(0);
        }
    }

    void set() {
        this.jb[4].setSelected(true);
        if (this.current == 0) {
            this.l.setText("Pertanyaan1: Yang mana di antara ini bukan tipe data");
            this.jb[0].setText("int");
            this.jb[1].setText("Float");
            this.jb[2].setText("boolean");
            this.jb[3].setText("char");
        }

        if (this.current == 1) {
            this.l.setText("Pertanyaan2: Kelas mana yang tersedia untuk semua kelas secara otomatis");
            this.jb[0].setText("Swing");
            this.jb[1].setText("Applet");
            this.jb[2].setText("Object");
            this.jb[3].setText("ActionEvent");
        }

        if (this.current == 2) {
            this.l.setText("Pertanyaan3: Paket mana yang langsung tersedia untuk kelas kita tanpa mengimpor");
            this.jb[0].setText("swing");
            this.jb[1].setText("applet");
            this.jb[2].setText("net");
            this.jb[3].setText("lang");
        }

        if (this.current == 3) {
            this.l.setText("Pertanyaan4: Kelas String didefinisikan dalam paket mana");
            this.jb[0].setText("lang");
            this.jb[1].setText("Swing");
            this.jb[2].setText("Applet");
            this.jb[3].setText("awt");
        }

        if (this.current == 4) {
            this.l.setText("Pertanyaan5: Institut mana yang terbaik untuk pelatihan java");
            this.jb[0].setText("Utek");
            this.jb[1].setText("Aptech");
            this.jb[2].setText("SSS IT");
            this.jb[3].setText("jtek");
        }

        if (this.current == 5) {
            this.l.setText("Pertanyaan6: Yang mana di antara ini bukan kata kunci");
            this.jb[0].setText("class");
            this.jb[1].setText("int");
            this.jb[2].setText("get");
            this.jb[3].setText("if");
        }

        if (this.current == 6) {
            this.l.setText("Pertanyaan7: Yang mana di antara ini bukan kelas ");
            this.jb[0].setText("Swing");
            this.jb[1].setText("Actionperformed");
            this.jb[2].setText("ActionEvent");
            this.jb[3].setText("Button");
        }

        if (this.current == 7) {
            this.l.setText("Pertanyaan8: Yang mana di antara ini bukan fungsi dari kelas Object");
            this.jb[0].setText("toString");
            this.jb[1].setText("finalize");
            this.jb[2].setText("equals");
            this.jb[3].setText("getDocumentBase");
        }

        if (this.current == 8) {
            this.l.setText("Pertanyaan9: Fungsi mana yang tidak ada dalam kelas Applet");
            this.jb[0].setText("init");
            this.jb[1].setText("main");
            this.jb[2].setText("start");
            this.jb[3].setText("destroy");
        }

        if (this.current == 9) {
            this.l.setText("Pertanyaan10: Yang mana di antara ini bukan komponen yang valid");
            this.jb[0].setText("JButton");
            this.jb[1].setText("JList");
            this.jb[2].setText("JButtonGroup");
            this.jb[3].setText("JTextArea");
        }

        this.l.setBounds(30, 40, 450, 20);
        int var1 = 0;

        for (int var2 = 0; var1 <= 90; ++var2) {
            this.jb[var2].setBounds(50, 80 + var1, 200, 20);
            var1 += 30;
        }

        this.getContentPane().setBackground(Color.BLUE);  // Atur latar belakang frame
        this.l.setOpaque(true);
        this.l.setBackground(Color.WHITE);
        this.l.setForeground(Color.BLACK);

        for (int i = 0; i < 4; i++) {
            this.jb[i].setOpaque(true);
            this.jb[i].setBackground(Color.PINK);
            this.jb[i].setForeground(Color.BLACK);
        }

        this.b1.setOpaque(true);
        this.b1.setBackground(Color.GREEN);
        this.b1.setForeground(Color.BLACK);

        this.b2.setOpaque(true);
        this.b2.setBackground(Color.YELLOW);
        this.b2.setForeground(Color.BLACK);
    }

    boolean check() {
        if (this.current == 0) {
            return this.jb[1].isSelected();
        } else if (this.current == 1) {
            return this.jb[2].isSelected();
        } else if (this.current == 2) {
            return this.jb[3].isSelected();
        } else if (this.current == 3) {
            return this.jb[0].isSelected();
        } else if (this.current == 4) {
            return this.jb[2].isSelected();
        } else if (this.current == 5) {
            return this.jb[2].isSelected();
        } else if (this.current == 6) {
            return this.jb[1].isSelected();
        } else if (this.current == 7) {
            return this.jb[3].isSelected();
        } else if (this.current == 8) {
            return this.jb[1].isSelected();
        } else {
            return this.current == 9 ? this.jb[2].isSelected() : false;
        }
    }

    public static void main(String[] var0) {
        SwingUtilities.invokeLater(() -> {
        LoginFrame loginFrame = new LoginFrame();


            loginFrame.setVisible(true);
        });
    }

    static class LoginFrame extends JFrame {
        JTextField usernameField;
        JPasswordField passwordField;
        JButton loginButton;

        public LoginFrame() {
            setTitle("Login");
            setSize(300, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            JLabel usernameLabel = new JLabel("Username:");
            JLabel passwordLabel = new JLabel("Password:");
            usernameField = new JTextField(15);
            passwordField = new JPasswordField(15);
            loginButton = new JButton("Login");

            panel.add(usernameLabel);
            panel.add(usernameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(loginButton);

            add(panel);

            loginButton.addActionListener(e -> {
                // Tambahkan logika login di sini
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Contoh: Jika username dan password sesuai, buka jendela game
                if (authenticate(username, password)) {
                    dispose();  // Tutup jendela login
                    openGameWindow();  // Buka jendela game
                } else {
                    JOptionPane.showMessageDialog(this, "Login gagal. Coba lagi.");
                }
            });
        }

        private boolean authenticate(String username, String password) {
            // Gantilah dengan logika otentikasi sesuai dengan kebutuhan aplikasi Anda
            return "admin".equals(username) && "admin".equals(password);
        }

        private void openGameWindow() {
            OnlineTest gameFrame = new OnlineTest("Ujian Online Java");
            gameFrame.setVisible(true);
            gameFrame.set();  // Panggil set() setelah menampilkan frame game
        }
    }
}
