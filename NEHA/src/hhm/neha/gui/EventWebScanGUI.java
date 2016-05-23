package hhm.neha.gui;

import hhm.neha.common.DefaultMessage;
import hhm.neha.common.JConsole;
import hhm.neha.common.JvmPid;
import hhm.neha.control.WebScanControl;
import hhm.neha.framework.ApplicationContextFactory;
import hhm.neha.framework.HibernateDataBaseCheck;
import hhm.neha.listener.MemoryListener;
import hhm.neha.listener.RunTimeListener;
import hhm.neha.process.WebSearchScanThread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**

 * 1.0.1
 * 1.0.2 修正了检索结果页面上时间的变化，采用date(time)方式来生成日期
 */
public class EventWebScanGUI extends JFrame {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6952181661039464109L;
	private static final String PROGRAM_NAME = "\u7f51\u7edc\u8206\u60c5\u4e8b\u4ef6\u626b\u63cf\u5668";
	private static final String PROGRAM_VERSION = "1.1.0.14233";
	private static Log LOG = LogFactory.getLog(EventWebScanGUI.class);
	private JMenuItem exitMenuItem;
	private JMenu optionMenus;
	private JMenuBar jMenuBar1;
	static private JTextPane statusbar_count_value;
	static private JPanel infoPanel;
	static private JTextPane memory_value;
	static private JTextPane memory;
	static private JTextPane statusbar_count;
	static private JTextPane programPID;
	static private JTextPane programPID_value;
	static private JTextPane runtime;
	static private JTextPane runtime_value;
	static private JScrollPane consoleScrollPane;
	static private JEditorPane consolePane;
	static private JPanel shortcut;
	static private JTextPane eventText;
	static private JTextField eventTextField;
	static private JButton submit;
	static private JPopupMenu consoleRight;
	private static ApplicationContext CONTEXT = ApplicationContextFactory.getInstance();
	private static boolean RUNNING = false;
	private static JConsole jConsole;
	private static int SCAN_COUNT = 0;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EventWebScanGUI inst = new EventWebScanGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JFrame.setDefaultLookAndFeelDecorated(true);
				FlowLayout flowLayout = new FlowLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setAlignOnBaseline(true);
				inst.setTitle(PROGRAM_NAME + " [" + PROGRAM_VERSION + "] " + " - " + DefaultMessage.SOFT_NAME + " - " + DefaultMessage.COMPANY_NAME);
				{
					consoleScrollPane = new JScrollPane();
					inst.getContentPane().add(consoleScrollPane, BorderLayout.CENTER);
					{
						consolePane = new JEditorPane();
						consoleScrollPane.setViewportView(consolePane);
						consolePane.setText("");
						setConsoleRight();
						jConsole = new JConsole(System.out, consolePane);
						System.setOut(jConsole);
						System.setErr(jConsole);
						consolePane.setEditable(false);
						consolePane.addMouseListener(new MouseAdapter() {
							/* (non-Javadoc)
							 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
							 */
							public void mouseReleased(MouseEvent e){
								if(e.getButton() == MouseEvent.BUTTON3){
									consolePane.add(consoleRight);
									consoleRight.show(e.getComponent(), e.getX(), e.getY());
								}
							}
						});
					}
				}
				{
					infoPanel = new JPanel();
					inst.getContentPane().add(infoPanel, BorderLayout.SOUTH);
					infoPanel.setBorder(new LineBorder(new Color(0,0,0), 1, false));
					infoPanel.setPreferredSize(new Dimension(784, 30));
					infoPanel.setLayout(flowLayout);
					{
						{
							statusbar_count = new JTextPane();
							infoPanel.add(statusbar_count);
							statusbar_count.setText(CONTEXT.getMessage("event.web.scan.statusbar.count", null, Locale.CHINA));
							statusbar_count.setBackground(null);
							statusbar_count.setEditable(false);
						}
						{
							statusbar_count_value = new JTextPane();
							infoPanel.add(statusbar_count_value);
							statusbar_count_value.setText(String.valueOf(SCAN_COUNT));
							statusbar_count_value.setBackground(null);
							statusbar_count_value.setEditable(false);
							statusbar_count_value.setEnabled(false);
						}
						{
							programPID = new JTextPane();
							infoPanel.add(programPID);
							programPID.setText("PID:");
							programPID.setBackground(null);
							programPID.setEditable(false);
						}
						{
							programPID_value = new JTextPane();
							infoPanel.add(programPID_value);							
							programPID_value.setText(JvmPid.getPID());
							programPID_value.setBackground(null);
							programPID_value.setEditable(false);
							programPID_value.setEnabled(false);
						}
						{
							memory = new JTextPane();
							infoPanel.add(memory);
							memory.setText(CONTEXT.getMessage("gobal.gui.memory", null, Locale.CHINA));
							memory.setBackground(null);
							memory.setEditable(false);
						}
						{
							memory_value = new JTextPane();
							infoPanel.add(memory_value);
							memory_value.setText("0KB");
							memory_value.setBackground(null);
							memory_value.setEditable(false);
							memory_value.setEnabled(false);
							MemoryListener memory = new MemoryListener(memory_value);
							memory.start();
						}
						{
							runtime = new JTextPane();
							infoPanel.add(runtime);
							runtime.setText(CONTEXT.getMessage("gobal.gui.runtime", null, Locale.CHINA));
							runtime.setBackground(null);
							runtime.setEditable(false);
						}
						{
							runtime_value = new JTextPane();
							infoPanel.add(runtime_value);
							runtime_value.setText("NULL");
							runtime_value.setBackground(null);
							runtime_value.setEditable(false);
							runtime_value.setEnabled(false);
						}
					}
				}
				{
					shortcut = new JPanel();
					inst.getContentPane().add(shortcut, BorderLayout.NORTH);
					shortcut.setSize(784, 35);
					shortcut.setPreferredSize(new Dimension(784, 35));
					shortcut.setBorder(new LineBorder(new Color(0,0,0), 1, false));
					shortcut.setLayout(new BorderLayout());
					{
						eventText = new JTextPane();
						shortcut.add(eventText, BorderLayout.WEST);
						eventText.setText(CONTEXT.getMessage("event.web.scan.name", null, Locale.CHINA) + ": ");
						eventText.setEditable(false);
						eventText.setEnabled(true);
						eventText.setBackground(null);
						eventText.setCaretColor(new Color(0, 0, 0));
					}
					{
						eventTextField = new JTextField();
						shortcut.add(eventTextField, BorderLayout.CENTER);
						eventTextField.setSize(500, 25);
						eventTextField.setText("");
						eventTextField.setPreferredSize(new Dimension(500, 25));
						eventTextField.setEditable(false);
					}
					{
						submit = new JButton();
						shortcut.add(submit, BorderLayout.EAST);
						submit.setText(CONTEXT.getMessage("gobal.gui.button.run", null, Locale.CHINA));
						submit.setSize(new Dimension(75, 25));
						submit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								try {
									submitActionPerformed(evt);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
			}
		});
		
	}
	
	/**
	 * 
	 */
	public EventWebScanGUI() {
		super();
		initGUI();
	}
	
	/**
	 * 
	 */
	private void initGUI() {
		try {
			setSize(900, 600);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					optionMenus = new JMenu();
					jMenuBar1.add(optionMenus);
					optionMenus.setText(CONTEXT.getMessage("gobal.menu.option", null, Locale.CHINA));
					{
						exitMenuItem = new JMenuItem();
						optionMenus.add(exitMenuItem);
						exitMenuItem.setText(CONTEXT.getMessage("gobal.menu.option.quit", null, Locale.CHINA));
						exitMenuItem.setMnemonic(KeyEvent.VK_Q);
						exitMenuItem.setAccelerator(
							javax.swing.KeyStroke.getKeyStroke(
								KeyEvent.VK_Q,
								Event.ALT_MASK,
								false));
						exitMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								windowsClosed();
							}
						});
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置控制台右键
	 */
	private static void setConsoleRight(){
		consoleRight = new JPopupMenu();
		consoleRight.setBorderPainted(true);
		consoleRight.setPopupSize(new Dimension(105, 135));
		JMenuItem clear = new JMenuItem(CONTEXT.getMessage("gobal.right.menu.clear", null, Locale.CHINA), KeyEvent.VK_L);
		JMenuItem copy = new JMenuItem(CONTEXT.getMessage("gobal.right.menu.copy", null, Locale.CHINA), KeyEvent.VK_C);
		JMenuItem cut = new JMenuItem(CONTEXT.getMessage("gobal.right.menu.cut", null, Locale.CHINA), KeyEvent.VK_X);
		JMenuItem font = new JMenuItem(CONTEXT.getMessage("gobal.right.menu.font", null, Locale.CHINA), KeyEvent.VK_F);
		JMenuItem choose = new JMenuItem(CONTEXT.getMessage("gobal.right.menu.choose", null, Locale.CHINA), KeyEvent.VK_O);
		JMenuItem saveas = new JMenuItem(CONTEXT.getMessage("gobal.right.menu.saveas", null, Locale.CHINA), KeyEvent.VK_S);
		consoleRight.add(clear);
		consoleRight.add(copy);
		consoleRight.add(cut);
		consoleRight.add(font);
		consoleRight.add(choose);
		consoleRight.add(saveas);
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				consolePane.setText("");
				jConsole.clear();
			}
		});
		copy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(consolePane.getText() != null && !consolePane.getText().trim().isEmpty()){
					Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
					Transferable tText = new StringSelection(consolePane.getText());
					clip.setContents(tText, null);
				}
				
			}
		});
		cut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(consolePane.getText() != null && !consolePane.getText().trim().isEmpty()){
					Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
					Transferable tText = new StringSelection(consolePane.getText());
					clip.setContents(tText, null);
				}
				consolePane.setText("");
				jConsole.clear();
			}
		});
		saveas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int option = fileChooser.showSaveDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						if (file.exists() == false) {
							file.createNewFile();
						}
						FileWriter writer = new FileWriter(file);
						char[] arry = consolePane.getText().toCharArray();
						writer.write(arry);
						writer.flush();
						writer.close();
						LOG.info(CONTEXT.getMessage("gobal.right.menu.saveas.success", null, Locale.CHINA));
					} catch (IOException ioe) {
					}
				}
			}
		});
	}
	/**
	 * 退出程序提示
	 */
	private void windowsClosed() {
		if (RUNNING) {
			int response = JOptionPane.showConfirmDialog(null, CONTEXT.getMessage("gobal.quit.dialog.msg", null, Locale.CHINA), CONTEXT.getMessage("gobal.quit.dialog.title", null, Locale.CHINA), JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JFrame#processWindowEvent(java.awt.event.WindowEvent)
	 */
	@Override
	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING){
			this.windowsClosed();
		}
		//super.processWindowEvent(e);
	}
	
	/**
	 * 点击运行
	 * @param evt
	 * @throws InterruptedException 
	 */
	private static void submitActionPerformed(ActionEvent evt) throws InterruptedException {
		WebSearchScanThread wssThread = WebSearchScanThread.Instance();
		if(RUNNING){
			wssThread.threadStop();
			JOptionPane.showConfirmDialog(null, CONTEXT.getMessage("gobal.stop.dialog.msg", null, Locale.CHINA), CONTEXT.getMessage("gobal.stop.dialog.title", null, Locale.CHINA), JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION);
			return;
		}
		submit.setText(CONTEXT.getMessage("gobal.gui.button.init", null, Locale.CHINA));
		submit.setEnabled(false);
		LOG.info(CONTEXT.getMessage("gobal.db.connect", null, Locale.CHINA));
		Thread.sleep(1000L);
		WebScanControl c = WebScanControl.getInstance();
		try{
			if(!HibernateDataBaseCheck.check()){
				LOG.error(CONTEXT.getMessage("gobal.db.connect.fail", null, Locale.CHINA));
				submit.setText(CONTEXT.getMessage("gobal.gui.button.run", null, Locale.CHINA));
				submit.setEnabled(true);
				return;
			}
		}catch (Exception e) {
			LOG.error(CONTEXT.getMessage("gobal.db.connect.fail", null, Locale.CHINA));
			submit.setText(CONTEXT.getMessage("gobal.gui.button.run", null, Locale.CHINA));
			submit.setEnabled(true);
			return;
		}
		LOG.info(CONTEXT.getMessage("gobal.db.connect.success", null, Locale.CHINA));
		Thread.sleep(500L);
		LOG.info(CONTEXT.getMessage("event.web.scan.event.check", null, Locale.CHINA));
		if(c.isExistEventList()){
			LOG.error(CONTEXT.getMessage("event.web.scan.event.null", null, Locale.CHINA));
			submit.setText(CONTEXT.getMessage("gobal.gui.button.run", null, Locale.CHINA));
			submit.setEnabled(true);
			return;
		}else{
			LOG.info(CONTEXT.getMessage("event.web.scan.event.check.success", null, Locale.CHINA));
		}
		LOG.info(CONTEXT.getMessage("event.web.scan.start", null, Locale.CHINA));
		Thread.sleep(1000L);
		submit.setText(CONTEXT.getMessage("gobal.gui.button.stop", null, Locale.CHINA));
		submit.setEnabled(true);
		RUNNING = true;
		RunTimeListener runTimeListener = new RunTimeListener(runtime_value);
		runTimeListener.start();
		wssThread.start();
	}
	
	
	/**
	 * 设置事件标题到地址栏
	 * @param text
	 */
	public static void setEventTextField(String text){
		if(text != null)
		eventTextField.setText(text);
	}
	
	/**
	 * 设置检索页面总数
	 */
	public static void setScanCount(){
		SCAN_COUNT+=1;
		statusbar_count_value.setText(String.valueOf(SCAN_COUNT));
	}
	
	public static void setButtonEnable(){
		submit.setEnabled(true);
	}
	
}
