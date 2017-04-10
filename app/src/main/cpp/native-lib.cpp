#include <jni.h>
#include <string>



extern "C" {
JNIEXPORT jstring JNICALL
Java_com_qixiaoyi_ycy_1master_SplashActivity_stringFromJNI2(JNIEnv *env, jobject instance) {

    // TODO
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
JNIEXPORT jstring JNICALL
Java_com_qixiaoyi_ycy_1master_SplashActivity_stringFromJNI(
        JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jstring JNICALL
Java_com_qixiaoyi_fascialibrary_FasiciaBaseActivity_stringFromJNI(JNIEnv *env, jobject instance) {

    // TODO
    std::string hello = "Hello from C++three";
    return env->NewStringUTF(hello.c_str());
}

}

