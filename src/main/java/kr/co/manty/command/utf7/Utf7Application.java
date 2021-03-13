package kr.co.manty.command.utf7;

import com.sun.mail.imap.protocol.BASE64MailboxDecoder;
import com.sun.mail.imap.protocol.BASE64MailboxEncoder;
import org.apache.commons.cli.*;

import java.sql.SQLOutput;

public class Utf7Application  {

    public static void main(String[] args){

        Option decode = new Option("d", "decode", true, "decode utf7");
        Option encode = new Option("e", "encode", true, "encode utf7");
        Options options = new Options();
        options.addOption(decode);
        options.addOption(encode);

        CommandLineParser parser = new BasicParser();

        CommandLine commandLine;
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println(e.getLocalizedMessage());
            return;
        }

        String output = null;
        if ( commandLine.hasOption("decode")) {
            output = BASE64MailboxDecoder.decode(commandLine.getOptionValue("decode"));
        }

        if ( commandLine.hasOption("encode")) {
            output = BASE64MailboxEncoder.encode(commandLine.getOptionValue("encode"));
        }

        if ( output != null )
            System.out.println(output);
    }

}
