package com.example.hellowrld;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class GLRenderer implements Renderer {
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
		// TODO Auto-generated method stub
		gl.glClearColor(.8f, 0f, .2f, .1f);
		gl.glClearDepthf(1f);
		
	}
	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	

}
