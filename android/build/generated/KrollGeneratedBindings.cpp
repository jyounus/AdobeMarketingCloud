/* C++ code produced by gperf version 3.0.3 */
/* Command-line: /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/gperf -L C++ -E -t /private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "co.uk.devpulse.adobemarketingcloud.ExampleProxy.h"
#include "co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudModule.h"
#include "co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudVideoAnalyticsProvider.h"
#include "co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudEnumHelperProxy.h"
#include "co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudMediaHeartbeatProxy.h"


#line 17 "/private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 30, duplicates = 0 */

class AdobeMarketingCloudBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
AdobeMarketingCloudBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct titanium::bindings::BindEntry *
AdobeMarketingCloudBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 5,
      MIN_WORD_LENGTH = 47,
      MAX_WORD_LENGTH = 76,
      MIN_HASH_VALUE = 47,
      MAX_HASH_VALUE = 76
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""},
#line 19 "/private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf"
      {"co.uk.devpulse.adobemarketingcloud.ExampleProxy", ::co::uk::devpulse::adobemarketingcloud::adobemarketingcloud::ExampleProxy::bindProxy, ::co::uk::devpulse::adobemarketingcloud::adobemarketingcloud::ExampleProxy::dispose},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""},
#line 20 "/private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf"
      {"co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudModule", ::co::uk::devpulse::adobemarketingcloud::AdobeMarketingCloudModule::bindProxy, ::co::uk::devpulse::adobemarketingcloud::AdobeMarketingCloudModule::dispose},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
#line 22 "/private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf"
      {"co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudEnumHelperProxy", ::co::uk::devpulse::adobemarketingcloud::adobemarketingcloud::AdobeMarketingCloudEnumHelperProxy::bindProxy, ::co::uk::devpulse::adobemarketingcloud::adobemarketingcloud::AdobeMarketingCloudEnumHelperProxy::dispose},
      {""}, {""}, {""},
#line 23 "/private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf"
      {"co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudMediaHeartbeatProxy", ::co::uk::devpulse::adobemarketingcloud::adobemarketingcloud::AdobeMarketingCloudMediaHeartbeatProxy::bindProxy, ::co::uk::devpulse::adobemarketingcloud::adobemarketingcloud::AdobeMarketingCloudMediaHeartbeatProxy::dispose},
      {""}, {""},
#line 21 "/private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf"
      {"co.uk.devpulse.adobemarketingcloud.AdobeMarketingCloudVideoAnalyticsProvider", ::co::uk::devpulse::adobemarketingcloud::adobemarketingcloud::AdobeMarketingCloudVideoAnalyticsProvider::bindProxy, ::co::uk::devpulse::adobemarketingcloud::adobemarketingcloud::AdobeMarketingCloudVideoAnalyticsProvider::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      unsigned int key = hash (str, len);

      if (key <= MAX_HASH_VALUE)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 24 "/private/var/folders/53/3pj2hcvx59b461j7q8tgfs600000gn/T/jayy/adobemarketingcloud-generated/KrollGeneratedBindings.gperf"

