package com.game.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	private Environment environment;
	private PerspectiveCamera camera;
	private CameraInputController cameraController;
	private ModelBatch modelBatch;
	private Model model;
	private ModelInstance instance;

	@Override
	public void create () {
		// Create an environment so we have some lighting
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		modelBatch = new ModelBatch();

		// Create a perspective camera with some sensible defaults
		camera = new PerspectiveCamera(100, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(0, 100f, 0f);
		camera.lookAt(50f, 0f, 05f);
		camera.near = 1f;
		camera.far = 300f;
		camera.update();

		// Import and instantiate our model (called "myModel.g3dj")
//		ModelBuilder modelBuilder = new ModelBuilder();
		model = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("chess/chess-board.g3dj"));
		instance = new ModelInstance(model);

		cameraController = new CameraInputController(camera);
		Gdx.input.setInputProcessor(cameraController);
	}

	@Override
	public void render () {
		cameraController.update();

		// Clear the stuff that is left over from the previous render cycle
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT
				| (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));


		// Let our ModelBatch take care of efficient rendering of our ModelInstance
		modelBatch.begin(camera);
		modelBatch.render(instance, environment);
		modelBatch.end();
	}

	@Override
	public void dispose () {
		modelBatch.dispose();
		model.dispose();
	}
}
