package com.cenfo.cenfomon.deskModule.desktop.utilities;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
public class TexturePackerTool {
    public static void main(String[]args){
        TexturePacker.process("res/un_packed","res/packed","textures");

    }
}
