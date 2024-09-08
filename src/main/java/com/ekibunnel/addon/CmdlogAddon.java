package com.ekibunnel.addon;

import com.ekibunnel.addon.commands.ErrorLog;
import com.ekibunnel.addon.commands.InfoLog;
import com.ekibunnel.addon.commands.WarnLog;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import org.slf4j.Logger;

public class CmdlogAddon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();


    @Override
    public void onInitialize() {
        LOG.info("Initializing Cmdlog Addon");

        // Commands
        Commands.add(new InfoLog());
        Commands.add(new WarnLog());
        Commands.add(new ErrorLog());
    }

    @Override
    public String getPackage() {
        return "com.ekibunnel.addon";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("Ekibunnel", "meteor-cmdlog-addon");
    }
}
