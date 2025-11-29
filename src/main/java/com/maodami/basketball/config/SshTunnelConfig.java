package com.maodami.basketball.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SshTunnelConfig {
    @Value("${ssh.host}")
    private String sshHost;

    @Value("${ssh.user}")
    private String sshUser;

    @Value("${ssh.password}")
    private String sshPassword;

    @PostConstruct
    public void setupTunnel() throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(sshUser, sshHost, 22);
        session.setPassword(sshPassword);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        session.setPortForwardingL(3307, "127.0.0.1", 3306);
        System.out.println("SSH隧道已建立");
    }
}
