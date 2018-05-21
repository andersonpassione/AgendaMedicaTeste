package logus.test.ws.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * Esta classe não pode ser alterada
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class GsonMessageBodyHandler implements MessageBodyWriter<Object>, MessageBodyReader<Object> {

	private static final String UTF_8 = "UTF-8";

	private Gson gson;

	private Gson getGson() {
		if (this.gson == null) {
			final GsonBuilder gsonBuilder = new GsonBuilder();
			this.gson = gsonBuilder.create();
		}
		return this.gson;
	}

	@Override
	public long getSize(final Object object, final Class<?> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isReadable(final Class<?> type, final Type genericType,
			final java.lang.annotation.Annotation[] annotations, final MediaType mediaType) {
		return true;
	}

	@Override
	public boolean isWriteable(final Class<?> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType) {
		return true;
	}

	@Override
	public Object readFrom(final Class<Object> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType, final MultivaluedMap<String, String> httpHeaders, final InputStream entityStream)
			throws UnsupportedEncodingException, IOException {
		InputStreamReader streamReader;
		streamReader = new InputStreamReader(entityStream, UTF_8);
		try {
			Type jsonType;
			if (type.equals(genericType)) {
				jsonType = type;
			} else {
				jsonType = genericType;
			}
			return getGson().fromJson(streamReader, jsonType);
		} finally {
			streamReader.close();
		}
	}

	@Override
	public void writeTo(final Object object, final Class<?> type, final Type genericType, final Annotation[] annotations,
			final MediaType mediaType, final MultivaluedMap<String, Object> httpHeaders, final OutputStream entityStream)
			throws IOException, WebApplicationException {
		final OutputStreamWriter writer = new OutputStreamWriter(entityStream, UTF_8);
		try {
			Type jsonType;
			if (type.equals(genericType)) {
				jsonType = type;
			} else {
				jsonType = genericType;
			}
			getGson().toJson(object, jsonType, writer);
		} finally {
			writer.close();
		}
	}
}