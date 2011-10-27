/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SimpleRecordPanel.java
 *
 * Created on Oct 25, 2011, 11:41:36 PM
 */

package com.googlecode.eckoit.audio.ui;

import com.googlecode.eckoit.audio.SplitAudioRecorderConfiguration;
import com.googlecode.eckoit.audio.SplitAudioRecorderManager;
import com.googlecode.eckoit.events.PostProcessingStartedEvent;
import com.googlecode.eckoit.events.RecordingCompleteEvent;
import com.googlecode.eckoit.events.RecordingStartClickedEvent;
import com.googlecode.eckoit.events.RecordingStartedResponseEvent;
import com.googlecode.eckoit.events.RecordingStopClickedEvent;
import com.googlecode.eckoit.events.RecordingStoppedResponseEvent;
import com.googlecode.eckoit.events.UploadingFinishedEvent;
import com.googlecode.eckoit.events.UploadingStartedEvent;
import java.awt.BorderLayout;
import java.io.File;
import java.util.UUID;
import javax.swing.JFrame;
import org.bushe.swing.event.EventBus;
import org.bushe.swing.event.EventSubscriber;

/**
 *
 * @author ryan
 */
public class SimpleRecordPanel extends javax.swing.JPanel {

    /** Creates new form SimpleRecordPanel */
    public SimpleRecordPanel() {
        initComponents();

        statusLabel.setVisible(false);

        EventBus.subscribeStrongly(RecordingStartedResponseEvent.class, new EventSubscriber<RecordingStartedResponseEvent>() {
            @Override
            public void onEvent(RecordingStartedResponseEvent t) {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });

        EventBus.subscribeStrongly(RecordingStoppedResponseEvent.class, new EventSubscriber<RecordingStoppedResponseEvent>() {
            @Override
            public void onEvent(RecordingStoppedResponseEvent t) {
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });


        EventBus.subscribeStrongly(PostProcessingStartedEvent.class, new EventSubscriber<PostProcessingStartedEvent>() {

            @Override
            public void onEvent(PostProcessingStartedEvent t) {
                statusLabel.setVisible(true);
                statusLabel.setText("Processing, please wait...");
            }
        });

        EventBus.subscribeStrongly(RecordingCompleteEvent.class, new EventSubscriber<RecordingCompleteEvent>() {
            @Override
            public void onEvent(RecordingCompleteEvent t) {
                statusLabel.setVisible(false);
                statusLabel.setText("");
            }
        });

        EventBus.subscribeStrongly(UploadingStartedEvent.class, new EventSubscriber<UploadingStartedEvent>() {

            @Override
            public void onEvent(UploadingStartedEvent t) {
                statusLabel.setVisible(true);
                statusLabel.setText("Uploading, please wait...");
            }
        });
        EventBus.subscribeStrongly(UploadingFinishedEvent.class, new EventSubscriber<UploadingFinishedEvent>() {

            @Override
            public void onEvent(UploadingFinishedEvent t) {
                statusLabel.setVisible(false);
                statusLabel.setText("");
            }
        });


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        timerLabel = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Audio Recording"));

        timerLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        timerLabel.setText("00:00:00");

        stopButton.setText("Stop");
        stopButton.setEnabled(false);
        stopButton.setMargin(new java.awt.Insets(0, 1, 0, 1));
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        statusLabel.setForeground(new java.awt.Color(153, 153, 255));
        statusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajax-loader.gif"))); // NOI18N
        statusLabel.setText("jLabel2");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(timerLabel)
                    .add(statusLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(stopButton, 0, 0, Short.MAX_VALUE)
                    .add(startButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(timerLabel)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(startButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(stopButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .add(statusLabel)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        EventBus.publish(new RecordingStopClickedEvent());
    }//GEN-LAST:event_stopButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        EventBus.publish(new RecordingStartClickedEvent(UUID.randomUUID().toString()));
    }//GEN-LAST:event_startButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                JFrame f = new JFrame();
                SimpleRecordPanel panel = new SimpleRecordPanel();
                f.getContentPane().setLayout(new BorderLayout());
                f.getContentPane().add(panel, BorderLayout.CENTER);


                // my machine
                String ffmpeg = "/Applications/eckoit/lib/ffmpeg";
                File file = new File("target");

                SplitAudioRecorderManager recorder = new SplitAudioRecorderManager(ffmpeg, file, new SplitAudioRecorderConfiguration());
                


                f.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                f.setVisible(true);
            }
        });
    }


}
