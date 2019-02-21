package com.sagold.cfievent.helpers

import com.jcraft.jsch.ChannelExec
import com.jcraft.jsch.JSch
import java.io.ByteArrayOutputStream
import java.util.*


class Tools {

    companion object {
        fun execSSHCommand(username: String, password: String, hostname: String, port: Int): String {
            val jsch = JSch()
            val session = jsch.getSession(username, hostname, port)
            session.setPassword(password)

            // Avoid asking for key confirmation
            val prop = Properties()
            prop.put("StrictHostKeyChecking", "no")
            session.setConfig(prop)

            session.connect()

            // SSH Channel
            val channelssh = session.openChannel("exec") as ChannelExec
            val baos = ByteArrayOutputStream()
            channelssh.outputStream = baos

            // Execute command
            channelssh.setCommand("ls")
            channelssh.connect()
            channelssh.disconnect()

            return baos.toString()
        }
    }
}